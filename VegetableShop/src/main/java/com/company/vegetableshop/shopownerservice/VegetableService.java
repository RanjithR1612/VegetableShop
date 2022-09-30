package com.company.vegetableshop.shopownerservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.company.vegetableshop.shopownermodel.Vegetable;
import com.company.vegetableshop.shopownermodel.VegetableReport;
import com.company.vegetableshop.shopownerrepository.VegetableRepository;

@Service
public class VegetableService {

	@Autowired
	VegetableRepository repository;

	public Vegetable createVegetable(Vegetable vegetable) {
		Vegetable dbVegetable = repository.save(vegetable);
		return dbVegetable;
	}
	
	public Vegetable readVegetable(String vegetable) {
		Vegetable read =  repository.findByVegetableId(vegetable);
		return read;
	}

//	public TreeSet<VegetableReport> readVegetables() {
//		List<Vegetable> vegetables = repository.findAll();
//		TreeSet<VegetableReport> reports = new TreeSet<>();
//		for (Vegetable vegetable : vegetables) {
//			VegetableReport report = new VegetableReport();
//			report.setName(vegetable.getName());
//			report.setPurchaseQuantity(vegetable.getPurchaseQuantity());
//			report.setAvailableQuantity(vegetable.getAvailableQuantity());
//			report.setVegetableId(vegetable.getVegetableId());
//		
//report.setProfit((vegetable.getSellingPrice() - vegetable.getBuyingPrice()) * (vegetable.getPurchaseQuantity() - vegetable.getAvailableQuantity()));
//			report.setQuantitysold(vegetable.getPurchaseQuantity() - vegetable.getAvailableQuantity()); 
//			reports.add(report);
//
//		}
//		
//		return reports;
//	}
	public List<VegetableReport> readVegetables() {
		
		List<Vegetable> vegetables = repository.findAll();
		List<VegetableReport> reports = new ArrayList<>();
		for (Vegetable vegetable : vegetables) {
			VegetableReport report = new VegetableReport();
			report.setName(vegetable.getName());
			report.setPurchaseQuantity(vegetable.getPurchaseQuantity());
			report.setAvailableQuantity(vegetable.getAvailableQuantity());
			report.setVegetableId(vegetable.getVegetableId());
			int price = (vegetable.getSellingPrice() - vegetable.getBuyingPrice()) / (vegetable.getPurchaseQuantity());
		report.setProfit((price) * (vegetable.getPurchaseQuantity() - vegetable.getAvailableQuantity()));
//report.setProfit((vegetable.getSellingPrice() - vegetable.getBuyingPrice()) * (vegetable.getPurchaseQuantity() - vegetable.getAvailableQuantity()));
			report.setQuantitysold(vegetable.getPurchaseQuantity() - vegetable.getAvailableQuantity()); 
			reports.add(report);

		}
		
		return reports;
	}
	public List<VegetableReport> findReportWithSorting(String field){
		List<Vegetable> vegetables = repository.findAll(Sort.by(Sort.Direction.ASC,field));
		List<VegetableReport> reports = new ArrayList<>();
		for (Vegetable vegetable : vegetables) {
			VegetableReport report = new VegetableReport();
			report.setName(vegetable.getName());
			report.setPurchaseQuantity(vegetable.getPurchaseQuantity());
			report.setAvailableQuantity(vegetable.getAvailableQuantity());
			report.setVegetableId(vegetable.getVegetableId());
		
report.setProfit((vegetable.getSellingPrice() - vegetable.getBuyingPrice()) * (vegetable.getPurchaseQuantity() - vegetable.getAvailableQuantity()));
			report.setQuantitysold(vegetable.getPurchaseQuantity() - vegetable.getAvailableQuantity()); 
			reports.add(report);

		}
		
		return reports;
	
	}

	public Vegetable updateQuantity(Vegetable vegetable) {
		Vegetable updatePQ= repository.findById(vegetable.getVegetableId()).get();
		
			updatePQ.setPurchaseQuantity(updatePQ.getPurchaseQuantity() + vegetable.getPurchaseQuantity());
			updatePQ.setAvailableQuantity(updatePQ.getAvailableQuantity() + vegetable.getPurchaseQuantity());
			
			updatePQ = repository.save(updatePQ);
			

		return updatePQ;
	}



}


