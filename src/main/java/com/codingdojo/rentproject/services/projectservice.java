package com.codingdojo.rentproject.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
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

}
