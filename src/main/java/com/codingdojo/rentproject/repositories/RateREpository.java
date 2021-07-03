package com.codingdojo.rentproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.rentproject.models.Rate;
@Repository
public interface RateREpository extends  CrudRepository<Rate,Long>{

}
