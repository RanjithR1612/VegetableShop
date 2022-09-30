package com.company.vegetableshop.customerservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.vegetableshop.customerorder.Order;
import com.company.vegetableshop.customerorder.OrderRequest;
import com.company.vegetableshop.customerrepository.OrderRepository;
import com.company.vegetableshop.shopownermodel.Vegetable;
import com.company.vegetableshop.shopownerrepository.VegetableRepository;
import com.company.vegetableshop.shoppingitem.ShoppingItem;

@Service
public class ShoppingService {
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	VegetableRepository vegRepo;

	public List<ShoppingItem> readVegetables() {
		List <Vegetable> vegetables = vegRepo.findAll();
		List<ShoppingItem> items = new ArrayList<>();
		for (Vegetable vegetable : vegetables) {
			ShoppingItem item = new ShoppingItem();
			item.setName(vegetable.getName());
			item.setPrice(vegetable.getSellingPrice());
			

			items.add(item);

		}
		return items;

	}

	public Object createOrder(List<OrderRequest> requests)  {

		float totalCost = 0;
	
		List<String> vegetableNames = new ArrayList<>();
		for (OrderRequest request : requests) {
			Vegetable vegetableFromDb = vegRepo.findByName(request.getName());
			String message = " ";
			if (vegetableFromDb == null) {
				message = "Vegetable with name " + request.getName() + " not found in the shop";
				return message;
				
			}
			if (request.getQuantity() > vegetableFromDb.getAvailableQuantity()) {
				message = "Vegetable with name " + request.getName() + " has only "+ vegetableFromDb.getAvailableQuantity()+"Kg";
				
		return message;
			}
			//vegetableNames.add(request.getName());
			totalCost = totalCost + vegetableFromDb.getSellingPrice() * request.getQuantity();
			 
		}

		Order order = new Order();
		//order.setOrderRequests(requests);

		
		order.setTotalCost(totalCost);
		Order orderFromDb = orderRepo.save(order);

		for (OrderRequest request : requests) {
			Vegetable vegetableFromDb = vegRepo.findByName(request.getName());

			int newAvailableQuantity = vegetableFromDb.getAvailableQuantity() - request.getQuantity();
			vegetableFromDb.setAvailableQuantity(newAvailableQuantity);
			vegRepo.save(vegetableFromDb);
		}
		return orderFromDb;
	}
}
