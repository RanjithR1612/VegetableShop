package com.company.vegetableshop.shopownerrepository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.company.vegetableshop.shopownermodel.Vegetable;

@Repository
public interface VegetableRepository extends MongoRepository<Vegetable, String> {


Vegetable findByVegetableId(String vegetable);
Vegetable findByName(String vegetableId);












}
