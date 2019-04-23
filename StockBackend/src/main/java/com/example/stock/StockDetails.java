package com.example.stock;

import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Column;;

@Entity             //class with stock details attributes calculated diff as well as from where to buy
public class StockDetails {
	    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Symbol == null) ? 0 : Symbol.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockDetails other = (StockDetails) obj;
		if (Symbol == null) {
			if (other.Symbol != null)
				return false;
		} else if (!Symbol.equals(other.Symbol))
			return false;
		return true;
	}
	double NSE,BSE,Diff,Per_diff;
	String Buy;
    @Id
    int SrNo;
    //@Column( unique = true)
    String Symbol;
    
	public double getNSE() {
		return NSE;
	}
	public void setNSE(double nSE) {
		NSE = nSE;
	}
	public double getBSE() {
		return BSE;
	}
	public void setBSE(double bSE) {
		BSE = bSE;
	}
	public double getDiff() {
		return Diff;
	}
	public void setDiff(double diff) {
		Diff = diff;
	}
	public double getPer_diff() {
		return Per_diff;
	}
	public void setPer_diff(double per_diff) {
		Per_diff = per_diff;
	}
	public String getSymbol() {
		return Symbol;
	}
	public void setSymbol(String symbol) {
		Symbol = symbol;
	}
	public int getSrNo() {
		return SrNo;
	}
	public void setSrNo(int srNo) {
		SrNo = srNo;
	}
	
	
	public String getBuy() {
		return Buy;
	}
	public void setBuy(String buy) {
		Buy = buy;
	}
	public void calculate_diff() {
		DecimalFormat twoDForm = new DecimalFormat("#.####");
		if(BSE>NSE) {
			 this.Buy="NSE";
			 setDiff(Double.valueOf(twoDForm.format(BSE-NSE)));
			 setPer_diff(Double.valueOf(twoDForm.format(((BSE-NSE)/NSE)*100)));
		}
		else {
			this.Buy="BSE";
			setDiff(Double.valueOf(twoDForm.format(NSE-BSE)));
			setPer_diff(Double.valueOf(twoDForm.format(((NSE-BSE)/BSE)*100)));
		}
	}
	public void update(StockDetails S) {
		this.BSE=S.BSE;
		this.NSE=S.NSE;
		this.Diff=S.Diff;
		this.Per_diff=S.Per_diff;
	}
	public int compareTo(StockDetails o) {
        return (int) (this.Per_diff - o.Per_diff);
    }
}
