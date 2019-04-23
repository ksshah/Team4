package com.example.stock;
import java.io.IOException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

	@Autowired
	private userDatabase UserDatabase;
	int at=1;
	
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
			result=1;
		return result;
	}

	@RequestMapping("/add")
	@GetMapping()
	@CrossOrigin(origins = "http://localhost:4200")
	public void Adding() {
		
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
 