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
	 @Query(value = "SELECT * FROM apartments join states as s on apartments.state_id=states.id WHERE where s.name = :state" , nativeQuery=true)
	 List<Apartment> state(@Param("state") String state);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE bedroomnum = :bedrooms" , nativeQuery=true)
	 List<Apartment> bedrooms(@Param("bedrooms") int bedrooms);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE bathroomnum = :bathrooms" , nativeQuery=true)
	 List<Apartment> bathrooms(@Param("bathrooms") int bathrooms);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE bathroomnum = :bathrooms AND bedroomnum = :bedrooms" , nativeQuery=true)
	 List<Apartment> bathroomsAndBedrooms(@Param("bathrooms") int bathrooms, @Param("bedrooms") int bedrooms);
	 
	 @Query(value = "SELECT * FROM project.apartments join states on apartments.state_id=states.id where states.name = :state AND price BETWEEN :startAt AND :endAt" , nativeQuery=true)
	 List<Apartment> priceAndState(@Param("state")String state, @Param("startAt") int startAt, @Param("endAt") int endAt);
	 
	 @Query(value = "SELECT * FROM project.apartments join states on apartments.state_id=states.id WHERE bedroomnum = :bedrooms AND states.name = :state" , nativeQuery=true)
	 List<Apartment> stateAndBedrooms(@Param("state") String state,@Param("bedrooms") int bedrooms);
	 
	 @Query(value = "SELECT * FROM project.apartments join states on apartments.state_id=states.id WHERE bathroomnum = :Bathrooms AND  states.name = :state" , nativeQuery=true)
	 List<Apartment> stateAndBathrooms(@Param("state") String state,@Param("Bathrooms") int Bathrooms);
	 
	 @Query(value = "SELECT * FROM project.apartments join states on apartments.state_id=states.id WHERE bathroomnum = :Bathrooms AND states.name = :state AND bedroomnum = :bedrooms" , nativeQuery=true)
	 List<Apartment> stateAndBathroomsAndBedrooms(@Param("state") String state,@Param("Bathrooms") int Bathrooms, @Param("bedrooms") int bedrooms);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE bedroomnum = :bedrooms AND price BETWEEN :startAt AND :endAt" , nativeQuery=true)
	 List<Apartment> priceAndBedrooms(@Param("bedrooms")int bedrooms, @Param("startAt") int startAt, @Param("endAt") int endAt);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE bathroomnum = :bathrooms AND price BETWEEN :startAt AND :endAt" , nativeQuery=true)
	 List<Apartment> priceAndBathrooms(@Param("bathrooms")int bathrooms, @Param("startAt") int startAt, @Param("endAt") int endAt);
	 
	 @Query(value = "SELECT * FROM project.apartments WHERE bathroomnum = :bathrooms  AND bedroomnum = :bedrooms AND price BETWEEN :startAt AND :endAt" , nativeQuery=true)
	 List<Apartment> priceAndBathroomsAndBedrooms( @Param("startAt") int startAt, @Param("endAt") int endAt, @Param("bathrooms")int bathrooms, @Param("bedrooms") int bedrooms);
	 
	 @Query(value = "SELECT * FROM project.apartments join states on apartments.state_id=states.id WHERE states.name = :state AND price BETWEEN :startAt AND :endAt AND bedroomnum = :bedrooms" , nativeQuery=true)
	 List<Apartment> priceAndStateAndBedrooms(@Param("state")String state, @Param("startAt") int startAt, @Param("endAt") int endAt,@Param("bedrooms") int bedrooms);
	 
	 @Query(value = "SELECT * FROM project.apartments  join states on apartments.state_id=states.id WHERE states.name = :state AND price BETWEEN :startAt AND :endAt AND bedroomnum = :bedrooms AND bathroomnum = :bathrooms" , nativeQuery=true)
	 List<Apartment> all(@Param("state")String state, @Param("startAt") int startAt, @Param("endAt") int endAt,@Param("bedrooms") int bedrooms, @Param("bathrooms") int bathrooms);
}

