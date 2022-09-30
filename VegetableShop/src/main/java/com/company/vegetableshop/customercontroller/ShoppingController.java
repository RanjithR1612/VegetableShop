package com.company.vegetableshop.customercontroller;

import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.vegetableshop.customerorder.OrderRequest;

import com.company.vegetableshop.customerservice.ShoppingService;
import com.company.vegetableshop.shopownermodel.Vegetable;
import com.company.vegetableshop.shoppingitem.ShoppingItem;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {
	
	@Autowired
	ShoppingService service;
	
	@GetMapping("/see")
	public List<ShoppingItem> readVegetables() {
		return service.readVegetables();
	}
	@PostMapping("/create")
	public  Object createOrder(@RequestBody List<OrderRequest> req){
		return service.createOrder(req);
	}

	

}
