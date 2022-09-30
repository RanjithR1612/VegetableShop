package com.company.vegetableshop.customerrepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.company.vegetableshop.customerorder.Order;
import com.company.vegetableshop.shopownermodel.Vegetable;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>{

	
	Order save(Order order);

}
