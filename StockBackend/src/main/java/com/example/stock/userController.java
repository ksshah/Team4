package com.example.stock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

	@Autowired
	private userDatabase UserDatabase;
	
	@Autowired
	private UserDBData Data;
	
	@Autowired
	private StockDatabase SD;
	
	//private int loggedin;
	
	private int result=0;
	
	@RequestMapping("/auth")
	@GetMapping()
	@CrossOrigin(origins = "http://localhost:4200")
	public int Auth(@RequestParam(value="U") String a,@RequestParam(value="P") String b) {
		result=0;
		User r=new User();
		r.setPassword(b);
		r.setUserName(a);
		User t=UserDatabase.login(r);
		if(t==null)
			result=0;
		else
			result=t.userid;
		return result;
	}

	@RequestMapping(value="/save/{id}",method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public void Adding(@PathVariable("id") String ids) {
		System.out.println(ids);
		String[] id=ids.split(",");
		System.out.println(id.length);
		int[] ads=new int[id.length];
		for(int i=0;i<id.length-1;i++) {
			ads[i]=Integer.parseInt(id[i]);
			System.out.println(ads[i]);
		}
		ads[ads.length-1]=Integer.parseInt(id[id.length-1]);
		System.out.println(ads[ads.length-1]);
		Data.add(ads,ads[ads.length-1]);
	}
	
	@RequestMapping(value="/data/{id}",method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<StockDetails> send(@PathVariable("id") String ids){
		System.out.println("in the show function");
		int Ids[]=Data.getAll(Integer.parseInt(ids));
		StockService s=new StockService();
		ArrayList<StockDetails> all=(ArrayList<StockDetails>) SD.GetAll();
		ArrayList<StockDetails> a=new ArrayList<StockDetails>();
		for(int i=0;i<all.size();i++) {
			for(int j=0;j<Ids.length;j++) {
				if(all.get(i).SrNo==Ids[j]) {
					System.out.println("Symbol:" +all.get(i).Symbol);
					a.add(all.get(i));
				}
			}
		}
		return a;
	}
	
}



/*
 * 
 * User a=null;
		System.out.println("The entered value"+u.userName);
		a=UserDatabase.login(u);
		return a;
		if(at==1) {
			User w=new User();
			w.setUserName("gargi");
			w.setPassword("dan");
			w.setUserid(1);
			UserDatabase.Add(w);
			System.out.println("Added successfully");
		}*/
 