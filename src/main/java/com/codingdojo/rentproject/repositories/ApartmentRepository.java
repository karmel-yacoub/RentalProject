package com.codingdojo.rentproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.rentproject.models.Apartment;
@Repository
public interface ApartmentRepository extends  CrudRepository<Apartment,Long>{
	List <Apartment> findAll();
}
