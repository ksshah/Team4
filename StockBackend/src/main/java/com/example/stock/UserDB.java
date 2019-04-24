package com.example.stock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity @IdClass(UserId.class)
public class UserDB {
	@Id
	int userid;
	@Id
	int stockid;

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
}
