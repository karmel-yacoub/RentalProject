package com.codingdojo.rentproject.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.rentproject.models.Role;

@Repository
public interface RoleRepository extends  CrudRepository <Role,Long> {

}
