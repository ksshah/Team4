package com.example.stock;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StockDatabase {
	
	@Autowired
	private stockRepository StockRepository;

	public void Add (StockDetails S) {
		//long s=StockRepository.count();
		if(StockRepository.existsById(S.SrNo)) {
			Optional<StockDetails> s=StockRepository.findById(S.SrNo);
			if (s.isPresent()){
			    StockDetails so = s.get();
			   so.update(S);
			}
		}
		else {
			StockRepository.save(S);
		}
		//return s;
	}
}
