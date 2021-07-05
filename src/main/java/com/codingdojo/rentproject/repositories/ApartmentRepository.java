package com.codingdojo.rentproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingdojo.rentproject.models.Apartment;
@Repository
public interface ApartmentRepository extends  CrudRepository<Apartment,Long>{
	List <Apartment> findAll();
	 @Query(value = "SELECT * FROM project.apartments WHERE price BETWEEN :startAt AND :endAt" , nativeQuery=true)
	 List<Apartment> price(@Param("startAt") int startAt, @Param("endAt") int endAt);
	 @Query(value = "SELECT * FROM project.apartments WHERE state_id == :state" , nativeQuery=true)
	 List<Apartment> state(@Param("state") int state);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE bedroomnum == :bedrooms" , nativeQuery=true)
	 List<Apartment> bedrooms(@Param("bedrooms") int bedrooms);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE bathroomnum == :bathrooms" , nativeQuery=true)
	 List<Apartment> bathrooms(@Param("bathrooms") int bathrooms);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE state_id == :state AND price BETWEEN :startAt AND :endAt" , nativeQuery=true)
	 List<Apartment> priceAndState(@Param("state")int state, @Param("startAt") int startAt, @Param("endAt") int endAt);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE bedroomnum == :bedrooms AND state_id == :state" , nativeQuery=true)
	 List<Apartment> stateAndBedrooms(@Param("state") int state,@Param("bedrooms") int bedrooms);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE bathroomnum == :Bathrooms AND state_id == :state" , nativeQuery=true)
	 List<Apartment> stateAndBathrooms(@Param("state") int state,@Param("Bathrooms") int Bathrooms);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE bedroomnum == :bedrooms AND price BETWEEN :startAt AND :endAt" , nativeQuery=true)
	 List<Apartment> priceAndBedrooms(@Param("bedrooms")int bedrooms, @Param("startAt") int startAt, @Param("endAt") int endAt);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE bathroomnum == :bathrooms AND price BETWEEN :startAt AND :endAt" , nativeQuery=true)
	 List<Apartment> priceAndBathrooms(@Param("bathrooms")int bathrooms, @Param("startAt") int startAt, @Param("endAt") int endAt);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE state_id == :state AND price BETWEEN :startAt AND :endAt AND bedroomnum == :bedrooms" , nativeQuery=true)
	 List<Apartment> priceAndStateAndBedrooms(@Param("state")int state, @Param("startAt") int startAt, @Param("endAt") int endAt,@Param("bedrooms") int bedrooms);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE state_id == :state AND price BETWEEN :startAt AND :endAt AND bedroomnum == :bedrooms AND bathroomnum == :bathrooms" , nativeQuery=true)
	 List<Apartment> priceAndStateAndBedroomsAndbathrooms(@Param("state")int state, @Param("startAt") int startAt, @Param("endAt") int endAt,@Param("bedrooms") int bedrooms, @Param("bathrooms") int bathrooms);
}

