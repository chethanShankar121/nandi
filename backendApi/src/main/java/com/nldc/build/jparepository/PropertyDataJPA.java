package com.nldc.build.jparepository;

import javax.persistence.Entity;
import com.nldc.build.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PropertyDataJPA extends JpaRepository<Property, Long>{
	

}
