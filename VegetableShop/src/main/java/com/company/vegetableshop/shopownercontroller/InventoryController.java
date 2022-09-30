package com.company.vegetableshop.shopownercontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.vegetableshop.shopownermodel.Vegetable;
import com.company.vegetableshop.shopownermodel.VegetableReport;
import com.company.vegetableshop.shopownerservice.VegetableService;

@RestController
@RequestMapping("/Inventory")
public class InventoryController {
	
	@Autowired
	VegetableService service;
	
	@PostMapping("/vegetable")
	public Vegetable createVegetable(@RequestBody Vegetable vegetable) {
		return service.createVegetable(vegetable);
		
	}
	@GetMapping("/vegetable/byId")
	public Vegetable readVegetable(@RequestParam("vegetableId") String id) {
		return service.readVegetable(id);
	}
	@GetMapping("/vegetables")
	public List<VegetableReport> readVegetables(){
		return service.readVegetables();
	}
	@GetMapping("/{field}")
	public List<VegetableReport> fieldReportWithSorting(@PathVariable String field){
		return service.findReportWithSorting(field);
	}
	
	
@PatchMapping("/updateVegetable")
	public Vegetable updateQuantity(@RequestBody Vegetable inputVegetable){
		return service.updateQuantity(inputVegetable);
	}
	
}
