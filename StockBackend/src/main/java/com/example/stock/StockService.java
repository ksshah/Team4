package com.example.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

class MyComparator implements Comparator<StockDetails>{
    @Override
    public int compare(StockDetails s, StockDetails o) {
        return (int) (o.Per_diff-s.Per_diff);
    }    
}

public class StockService {
	
	public ArrayList<StockDetails> GetStocks() throws IOException{
		
		ArrayList<StockDetails> StockList=new ArrayList<StockDetails>();
		String Stocks[]= {"yesbank","wipro","tatamotors","hcltech","coalindia","bajaj-auto","zeel","ioc","bpcl","cipla","techm","icicibank","sunpharma","itc","tcs","heromotoco","hindunilvr","ntpc","maruti","axisbank","infratel","powergrid","ongc","indusindbk","reliance","lt","sbin","hdfc","hindalco","m&m","kotakbank","infy","eichermot","drreddy","hdfcbank","vedl","bajajfinsv","adaniports","gail","upl","tatasteel","grasim","titan","britannia","bajfinance","jswsteel","ultracemco","bhartiartl","ibulhsgfin","asianpaint"};
		String Api="https://query1.finance.yahoo.com/v7/finance/quote?symbols=";
		
		for(int i=0;i<50;i++) {
			StockDetails se=new StockDetails();
			se.setSymbol(Stocks[i].toUpperCase());
			se.setSrNo(i+1);
			String Data=getDataFromURL(Api+Stocks[i]+".ns,"+Stocks[i]+".bo");
			JSONObject myResponse= new JSONObject(Data);
			JSONObject Object=(JSONObject)myResponse.get("quoteResponse");
			Data="";
			JSONArray dataarray=(JSONArray) Object.get("result");
			for(int j=0;j<dataarray.length();j++) {
				Object=dataarray.getJSONObject(j);
				if(j==0) {
					se.setNSE(Double.valueOf(Object.get("regularMarketPrice").toString()));
				}
				else{
					se.setBSE(Double.valueOf(Object.get("regularMarketPrice").toString()));
				}
			}
			if(se.BSE!=0 && se.NSE!=0) {
				se.calculate_diff();
				StockList.add(se);
			}
		}
		StockList=SortStocks(StockList);
		return StockList;
	}
	public boolean contain(ArrayList<StockDetails> s, StockDetails sd) {
		boolean check=false;
		for(int i=0;i<s.size();i++) {
			if(s.get(i).Symbol.compareTo(sd.Symbol)==0)
			{
				check=true;
				break;
			}
		}
		return check;
	}
	public String getDataFromURL(String U) throws IOException {          //gets data from api 
        URL obj = new URL(U);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
        	response.append(inputLine);
        }
        in.close();
        String d=response.toString();
        return d;
	}
	public ArrayList<StockDetails> SortStocks(ArrayList<StockDetails> stockList){
		
		Collections.sort(stockList,(s1, s2) ->
	    Double.compare(s2.getPer_diff(), s1.getPer_diff()));
		for(int i=0;i<stockList.size();i++) {
			if(stockList.get(i).Diff==0 ||stockList.get(i).BSE==0 ||stockList.get(i).NSE==0)
				stockList.remove(i);
		}
		return stockList;
	}

}
