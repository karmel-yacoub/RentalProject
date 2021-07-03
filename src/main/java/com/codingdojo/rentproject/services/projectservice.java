package com.codingdojo.rentproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.rentproject.models.Role;
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
}
