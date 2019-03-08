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
	User admin = new User();
	admin.setEmail("paferpe@crossfit.es");
	admin.setLastName("Dios");
	admin.setName("Pafuerte");
	admin.setPassword("admin123");
	admin.setPasswordConfirm("admin123");
	admin.setRole(Rol.ROL_ADMIN);
	us.addUser(admin);
	User user = new User();
	user.setEmail("cueva@subnormal.es");
	user.setLastName("Mental");
	user.setName("Retrasao");
	user.setPassword("user123");
	user.setPasswordConfirm("user123");
	user.setRole(Rol.ROL_STAND);
	us.addUser(user);
    }
    
}
