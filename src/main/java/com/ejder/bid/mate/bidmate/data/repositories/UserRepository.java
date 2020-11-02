package com.ejder.bid.mate.bidmate.data.repositories;

import com.ejder.bid.mate.bidmate.data.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

}
