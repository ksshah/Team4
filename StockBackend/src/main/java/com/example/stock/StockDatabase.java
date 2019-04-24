package com.example.stock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockDatabase {
	
	@Autowired
	private stockRepository StockRepository;

	public Long Add (StockDetails S) {
		long s=StockRepository.count();
		if(StockRepository.existsById(S.SrNo)) {
			Optional<StockDetails> s1=StockRepository.findById(S.SrNo);
			if (s1.isPresent()){
			    StockDetails so = s1.get();
			   so.update(S);
			}
		}
		else {
			StockRepository.save(S);
		}
		return s;
	}
	
	public Collection<StockDetails> GetAll(){
		ArrayList<StockDetails> s=(ArrayList<StockDetails>) StockRepository.findAll();
		return s;
	}
}
