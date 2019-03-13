package com.uniovi.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Sale;
import com.uniovi.entities.User;
import com.uniovi.entities.types.Role;

@Service
public class InsertData {
    
    @Autowired
    private UsersService us; 
    
    @Autowired
    private SalesService ss; 

    @PostConstruct
    public void insert() {
	User admin1 = new User();
	admin1.setEmail("pablo@uniovi.es");
	admin1.setLastName("Uniovi");
	admin1.setName("Pablo");
	admin1.setPassword("admin123");
	admin1.setPasswordConfirm("admin123");
	admin1.setRole(Role.ROLE_ADMIN);
	us.addUser(admin1);
	
	User admin2 = new User();
	admin2.setEmail("cristobal@uniovi.es");
	admin2.setLastName("Soler");
	admin2.setName("Cristóbal");
	admin2.setPassword("admin123");
	admin2.setPasswordConfirm("admin123");
	admin2.setRole(Role.ROLE_ADMIN);
	us.addUser(admin2);
	
	User user1 = new User();
	user1.setEmail("chunkyLover53@aol.com");
	user1.setLastName("Simpson");
	user1.setName("Homer");
	user1.setPassword("user123");
	user1.setPasswordConfirm("user123");
	user1.setRole(Role.ROLE_STAND);
	us.addUser(user1);
	
	User user2 = new User();
	user2.setEmail("miguiAmpliaciones@gmail.com");
	user2.setLastName("Rodríguez");
	user2.setName("Miguel");
	user2.setPassword("user123");
	user2.setPasswordConfirm("user123");
	user2.setRole(Role.ROLE_STAND);
	us.addUser(user2);
	
	User user3 = new User();
	user3.setEmail("pizzasPastrana@yahoo.com");
	user3.setLastName("Álvarez");
	user3.setName("Manolo");
	user3.setPassword("user123");
	user3.setPasswordConfirm("user123");
	user3.setRole(Role.ROLE_STAND);
	us.addUser(user3);
	
	ss.add(new Sale("Dildo de fibra de carbono", "Un pedazo de nabo de mentira", 20.00), user1);
    }
    
}
