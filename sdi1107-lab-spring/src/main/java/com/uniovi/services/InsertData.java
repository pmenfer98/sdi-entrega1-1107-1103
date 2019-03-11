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
	User admin1 = new User();
	admin1.setEmail("pablo@uniovi.es");
	admin1.setLastName("Pablo");
	admin1.setName("Pafuerte");
	admin1.setPassword("admin123");
	admin1.setPasswordConfirm("admin123");
	admin1.setRole(Rol.ROL_ADMIN);
	us.addUser(admin1);
	
	User user1 = new User();
	user1.setEmail("cristobal@uniovi.es");
	user1.setLastName("Soler");
	user1.setName("Cristóbal");
	user1.setPassword("user123");
	user1.setPasswordConfirm("user123");
	user1.setRole(Rol.ROL_STAND);
	us.addUser(user1);
	
	User user2 = new User();
	user2.setEmail("baruque@patria.es");
	user2.setLastName("Baruque");
	user2.setName("Ignacio");
	user2.setPassword("user123");
	user2.setPasswordConfirm("user123");
	user2.setRole(Rol.ROL_STAND);
	us.addUser(user2);
	
	User user3 = new User();
	user3.setEmail("pastrana98@gmail.es");
	user3.setLastName("Pastrana");
	user3.setName("Luis");
	user3.setPassword("user123");
	user3.setPasswordConfirm("user123");
	user3.setRole(Rol.ROL_STAND);
	us.addUser(user3);
	
    }
    
}
