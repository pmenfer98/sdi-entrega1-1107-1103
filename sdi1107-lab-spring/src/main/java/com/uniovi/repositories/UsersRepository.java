package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniovi.entities.User;
import com.uniovi.entities.types.Role;

public interface UsersRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    
    List<User> findByValidAndRole(boolean active, Role role);
    
}
