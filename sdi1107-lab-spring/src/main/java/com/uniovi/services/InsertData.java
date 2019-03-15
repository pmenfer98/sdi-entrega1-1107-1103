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
	user1.setMoney(100.0);
	user1.setRole(Role.ROLE_STAND);
	us.addUser(user1);
	
	User user2 = new User();
	user2.setEmail("miguiAmpliaciones@gmail.com");
	user2.setLastName("Rodríguez");
	user2.setName("Miguel");
	user2.setPassword("user123");
	user2.setPasswordConfirm("user123");
	user2.setMoney(100.0);
	user2.setRole(Role.ROLE_STAND);
	us.addUser(user2);
	
	User user3 = new User();
	user3.setEmail("pizzasPastrana@yahoo.com");
	user3.setLastName("Álvarez");
	user3.setName("Manolo");
	user3.setPassword("user123");
	user3.setPasswordConfirm("user123");
	user3.setMoney(100.0);
	user3.setRole(Role.ROLE_STAND);
	us.addUser(user3);
	
	ss.add(new Sale("Raqueta de tenis Babolat", "Con cordajes y grips recambiables", 90.00), user1);
	ss.add(new Sale("Set de discos olímpicos Eleiko", "10, 15 y 20 kg", 80), user1);
	ss.add(new Sale("Fin de semana en una casa rural en Faluya, Siria", "Con piscina y vistas al campo de minas (Precio por día)", 70), user1);
	ss.add(new Sale("Seat Panda", "Un coche", 20000.00), user2);
	ss.add(new Sale("Película Dolor y Dinero", "Un cancer de película, casi vomito 7 veces", 10.0), user2);
	ss.add(new Sale("Carcasa de pugs para móvil", "Disponible para Xiaomi y Apple", 5.00), user2);
	ss.add(new Sale("Set de dinosaurios de juguete", "Fantásticos para pasar el día en familia", 100.00), user3);
	ss.add(new Sale("Pórtatil Acer", "No funciona bien y es rojo", 700.00), user3);
	ss.add(new Sale("Dildo de plata", "No usar si eres vampiro", 90.00), user1);
	ss.add(new Sale("Dildo de cobre", "Dildo del primo Jonatan", 80), user1);
	ss.add(new Sale("Camiseta Powerexplosive", "Pa ser el reshulon del gym", 20.00), user1);
	ss.add(new Sale("Disco de ACDC Back in Black", "La puta crema", 15.00), user1);
	ss.add(new Sale("Gladiator", "Esta si que es una peli de verdad ostia", 10.0), user2);
	ss.add(new Sale("Pulp Fiction", "Aprende lo que es el cine Paferpe", 5.00), user2);
    }
    
}
