package com.codingdojo.rentproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.rentproject.models.Role;
import com.codingdojo.rentproject.models.User;

@Repository
public interface UserRepository extends  CrudRepository<User,Long> {
	User findByEmail(String email);
	List <User> findByRole(Role role);
}
