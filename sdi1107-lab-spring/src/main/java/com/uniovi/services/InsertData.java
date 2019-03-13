package com.uniovi.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Sale;
import com.uniovi.entities.User;
import com.uniovi.entities.types.Rol;

@Service
public class InsertData {
    
    @Autowired
    private UsersService us; 
    
    @Autowired
    private SalesService ss; 

    @PostConstruct
    public void insert() {
	User user = new User();
	user.setEmail("paferpe@crossfit.es");
	user.setLastName("Pablo");
	user.setName("Pafuerte");
	user.setPassword("user123");
	user.setPasswordConfirm("user123");
	user.setRole(Rol.ROL_STAND);
	us.addUser(user);
	User admin = new User();
	admin.setEmail("cueva@subnormal.es");
	admin.setLastName("Cueva");
	admin.setName("Imbecil");
	admin.setPassword("admin123");
	admin.setPasswordConfirm("admin123");
	admin.setRole(Rol.ROL_ADMIN);
	us.addUser(admin);
	ss.add(new Sale("Dildo de fibra de carbono", "Un pedazo de nabo de mentira", 20.00), user);
    }
    
}
