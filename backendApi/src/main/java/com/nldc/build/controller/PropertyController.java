package com.nldc.build.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nldc.build.model.Property;
import com.nldc.build.model.ResponseModel;
import com.nldc.build.service.PropertyService;

@RestController
public class PropertyController {
	
	@Autowired
	PropertyService propertyService;
	
	@PostMapping(value="/addProperty", consumes = "application/json", produces = "application/json")
	public ResponseModel addProperty(@RequestBody Property property) {
		return propertyService.addProperty(property);
	}
	
	@GetMapping(value="/getAllProperties", produces="application/json")
	public List<Property> getAllProperties(){
		return propertyService.findAllProperties();
	}

}
