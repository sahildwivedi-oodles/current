package com.example.traning.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.traning.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findOneByRole(String string);

	Role findByRole(String role);
	
	

}