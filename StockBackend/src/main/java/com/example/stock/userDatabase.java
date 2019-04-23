package com.example.stock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userDatabase {

	@Autowired
	private userRepository UserRepository;

	public User login(User a) {          //checks for login
		ArrayList<User> s=(ArrayList<User>) UserRepository.findAll();
		int flag=0;
		User d=new User();
		//System.out.println(s.size()+" size ");
		for(int i=0;i<s.size();i++) {
			d=s.get(i);
			if((d.userName.compareTo(a.userName)==0) &&(d.password.compareTo(a.password)==0)) {
				//System.out.println(d.userName+" found ");
				flag=1;
				break;
			}
		}
		if(flag==0)
			d=null;
		return d;
	}
}
