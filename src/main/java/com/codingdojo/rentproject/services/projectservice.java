package com.codingdojo.rentproject.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.codingdojo.rentproject.models.Apartment;
import com.codingdojo.rentproject.models.Role;
import com.codingdojo.rentproject.models.User;
import com.codingdojo.rentproject.repositories.ApartmentRepository;
import com.codingdojo.rentproject.repositories.RateREpository;
import com.codingdojo.rentproject.repositories.RoleRepository;
import com.codingdojo.rentproject.repositories.UserRepository;


@Service
public class projectservice {
private final ApartmentRepository AR;
private final RateREpository RateR;
private final RoleRepository RoleR;
private final UserRepository UR;
public projectservice(ApartmentRepository aR, RateREpository rateR, RoleRepository roleR, UserRepository uR) {
	AR = aR;
	RateR = rateR;
	RoleR = roleR;
	UR = uR;
}
public List<Role> allRoles() {
	
	return RoleR.findAll();
}
<<<<<<< HEAD
public User registerUser(@Valid User user) {
	
     return UR.save(user);
	
}
=======
public List<Apartment> allApartments(){
	return AR.findAll();
	
}
public Apartment apartmentById(long id) {
	return AR.findById(id).get();
}
public List<User> allAgents(){
	return UR.findByRole("agent");
}

public User userById(long id) {
	return UR.findById(id).get();
}
>>>>>>> 2f1d87ca0a06904db9f3f6a1c7ae3fc9a8f0e09e
}
