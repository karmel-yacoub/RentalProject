package com.codingdojo.rentproject.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.rentproject.models.Apartment;
import com.codingdojo.rentproject.models.Role;
import com.codingdojo.rentproject.models.State;
import com.codingdojo.rentproject.models.User;
import com.codingdojo.rentproject.repositories.ApartmentRepository;
import com.codingdojo.rentproject.repositories.RateREpository;
import com.codingdojo.rentproject.repositories.RoleRepository;
import com.codingdojo.rentproject.repositories.StateRepository;
import com.codingdojo.rentproject.repositories.UserRepository;


@Service
public class projectservice {
private final ApartmentRepository AR;
private final RateREpository RateR;
private final RoleRepository RoleR;
private final UserRepository UR;
private final StateRepository SR;
public projectservice(ApartmentRepository aR, RateREpository rateR, RoleRepository roleR, UserRepository uR, StateRepository sR) {
	AR = aR;
	RateR = rateR;
	RoleR = roleR;
	UR = uR;
	SR = sR;
}
public List<Role> allRoles() {
	
	return RoleR.findAll();
}

//register user and hash their password
public User registerUser(User user) {
    String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
    user.setPassword(hashed);
    return UR.save(user);
}

// find user by email
public User findByEmail(String email) {
    return UR.findByEmail(email);
}

// find user by id
public User findUserById(Long id) {
	Optional<User> u = UR.findById(id);
	
	if(u.isPresent()) {
        return u.get();
	} else {
	    return null;
	}
}

// authenticate user
public boolean authenticateUser(String email, String password) {
    // first find the user by email
    User user = UR.findByEmail(email);
    // if we can't find it by email, return false
    if(user == null) {
        return false;
    } else {
        // if the passwords match, return true, else, return false
        if(BCrypt.checkpw(password, user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}

public List<Apartment> allApartments(){
	return AR.findAll();
	
}
public Apartment apartmentById(long id) {
	return AR.findById(id).get();
}
public Role roleById(long id) {
	return RoleR.findById(id).get();
}
public List<User> allAgents(){
	Role x = roleById(3);
	return UR.findByRole(x);
}


public User userById(long id) {
	return UR.findById(id).get();
}
public List<State> allStates(){
	return SR.findAll();
}
public List<Apartment> filteredApartments(String state, int price, int bedrooms , int bathrooms){
	System.out.println("in");
	if (!state.equals("all") && price == 0 && bedrooms == 0 && bathrooms == 0) {
		System.out.println("state");
		return AR.state(state);}
	else if (!state.equals("all") && price != 0 && bedrooms == 0 && bathrooms == 0) {
		System.out.println("in2");
		return AR.price(0, price);}
	else if (!state.equals("all") && price == 0 && bedrooms != 0 && bathrooms == 0) {
		System.out.println("in3");
		return AR.bedrooms(bedrooms);}
	else if (!state.equals("all") && price == 0 && bedrooms == 0 && bathrooms != 0) {
		System.out.println("in4");
		return AR.bathrooms(bathrooms);}
	else if (!state.equals("all") && price == 0 && bedrooms != 0 && bathrooms != 0) {
		System.out.println("in4");
		return AR.bathroomsAndBedrooms(bathrooms, bedrooms);}	
	else if (!state.equals("all") && price != 0 && bedrooms == 0 && bathrooms == 0) {
		System.out.println("in5");
	return AR.priceAndState(state,0, price);}
	else if (!state.equals("all") && price == 0 && bedrooms != 0 && bathrooms == 0) {
		System.out.println("in6");
		return AR.stateAndBedrooms(state, bedrooms);}
	else if (!state.equals("all") && price == 0 && bedrooms == 0 && bathrooms != 0) {
		System.out.println("in7");
		return AR.stateAndBathrooms(state, bathrooms);}
	else if (!state.equals("all") && price == 0 && bedrooms == 0 && bathrooms != 0) {
		System.out.println("in7");
		return AR.stateAndBathroomsAndBedrooms(state, bathrooms, bedrooms);}
	else if (!state.equals("all") && price != 0 && bedrooms != 0 && bathrooms == 0) {
		System.out.println("in8");
		return AR.priceAndBedrooms(0, price, bedrooms);}
	else if (!state.equals("all") && price != 0 && bedrooms == 0 && bathrooms != 0) {
		System.out.println("in9");
		return AR.priceAndBathrooms(0, price, bathrooms);}
	else if (!state.equals("all") && price != 0 && bedrooms != 0 && bathrooms != 0) {
		System.out.println("in119");
		return AR.priceAndBathroomsAndBedrooms(0, price,  bathrooms , bedrooms);}
	else if (!state.equals("all") && price != 0 && bedrooms != 0 && bathrooms == 0) {
		System.out.println("in9");
		return AR.priceAndStateAndBedrooms(state,0, price, bedrooms);}
	else if (!state.equals("all") && price != 0 && bedrooms != 0 && bathrooms != 0) {
		System.out.println("in10");
		return AR.all(state,0, price, bedrooms, bathrooms);}
	else System.out.println("in11"); return allApartments();
}



public void createapp(Apartment app) {
	AR.save(app);
}
public void deleteprop(Long id) {
	AR.deleteById(id);
}
public void deleteAgent(Long id) {
	UR.deleteById(id);
}
}
