package com.codingdojo.rentproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.rentproject.models.State;

@Repository
public interface StateRepository extends  CrudRepository<State,Long> {
	List<State> findAll();

}
