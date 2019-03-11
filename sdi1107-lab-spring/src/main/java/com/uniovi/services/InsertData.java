package com.uniovi.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.User;
import com.uniovi.entities.types.Rol;

@Service
public class InsertData {
    
    @Autowired
    private UsersService us; 

    @PostConstruct
    public void insert() {
	User user = new User();
	user.setEmail("paferpe@crossfit.es");
	user.setLastName("Pablo");
	user.setName("Pafuerte");
	user.setPassword("admin123");
	user.setPasswordConfirm("admin123");
	user.setRole(Rol.ROL_STAND);
	us.addUser(user);

    }
    
}
