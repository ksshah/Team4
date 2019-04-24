package com.example.stock;


import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                         //controller asks service to get data about stocks
public class StockController {
	
	@Autowired
	private StockService s;
	
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<StockDetails> getSort() throws IOException{
		return s.GetStocks();
	}
}
