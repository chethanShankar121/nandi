package com.nldc.build.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nldc.build.jparepository.PropertyDataJPA;
import com.nldc.build.model.Property;
import com.nldc.build.model.ResponseModel;

@Component
public class PropertyService {
	
	@Autowired
	PropertyDataJPA propertyJpa;
	
	public ResponseModel addProperty(Property property) {
		propertyJpa.save(property);
		HashMap<String, Object> addtionalDetails = new HashMap<>();
		addtionalDetails.put("propertyId", property);
		return new ResponseModel(200, "Successfully added", addtionalDetails);
	}
	
	public List<Property> findAllProperties() {
		return propertyJpa.findAll();
	}

}
