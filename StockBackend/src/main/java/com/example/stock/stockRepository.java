package com.example.stock;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface stockRepository extends CrudRepository<StockDetails, Integer> {

}
