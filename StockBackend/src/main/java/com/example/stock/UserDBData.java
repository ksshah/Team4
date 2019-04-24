package com.example.stock;


import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDBData {

	@Autowired
	private UserDBRepo userre;
	
	public int add(int[] pl,int user) {
		int i=0;
		for(int j=0;j<pl.length-1;j++) {
			UserDB d=new UserDB();
			d.setUserid(user);
			d.setStockid(pl[j]);
			//System.out.println(d.getNewdate());
			userre.save(d);
			d=null;
		}
		
		return i;
	}
	public int[] getAll(int id) {
		ArrayList<UserDB> s=(ArrayList<UserDB>) userre.findAll();
		int st[]=new int[s.size()];
		int k=0;
		for(int i=0;i<s.size();i++) {
			UserDB a=s.get(i);
			if(a.userid==id) {
				System.out.println(a.stockid);
				st[k]=a.stockid;
				k++;
			}
		}
		return st;
	}
}
