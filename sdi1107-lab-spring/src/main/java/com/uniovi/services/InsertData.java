package com.uniovi.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.User;
import com.uniovi.entities.types.Role;

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
	admin1.setRole(Role.ROL_ADMIN);
	us.addUser(admin1);
	
	User user1 = new User();
	user1.setEmail("cristobal@uniovi.es");
	user1.setLastName("Soler");
	user1.setName("Cristóbal");
	user1.setPassword("user123");
	user1.setPasswordConfirm("user123");
	user1.setRole(Role.ROL_STAND);
	us.addUser(user1);
	
	User user2 = new User();
	user2.setEmail("baruque@patria.es");
	user2.setLastName("Baruque");
	user2.setName("Ignacio");
	user2.setPassword("user123");
	user2.setPasswordConfirm("user123");
	user2.setRole(Role.ROL_STAND);
	us.addUser(user2);
	
	User user3 = new User();
	user3.setEmail("pastrana98@gmail.es");
	user3.setLastName("Pastrana");
	user3.setName("Luis");
	user3.setPassword("user123");
	user3.setPasswordConfirm("user123");
	user3.setRole(Role.ROL_STAND);
	us.addUser(user3);
	
	User user4 = new User();
	user4.setEmail("lucasGarcia24@outlook.es");
	user4.setLastName("García");
	user4.setName("Lucas");
	user4.setPassword("user123");
	user4.setPasswordConfirm("user123");
	user4.setRole(Role.ROL_STAND);
	us.addUser(user4);
	
	User user5 = new User();
	user5.setEmail("chunkyLover53@aol.com");
	user5.setLastName("Simpson");
	user5.setName("Homer");
	user5.setPassword("user123");
	user5.setPasswordConfirm("user123");
	user5.setRole(Role.ROL_STAND);
	us.addUser(user5);
	
    }
    
}
