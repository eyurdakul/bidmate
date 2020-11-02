package com.ejder.bid.mate.bidmate.data.repositories;

import com.ejder.bid.mate.bidmate.data.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

}
