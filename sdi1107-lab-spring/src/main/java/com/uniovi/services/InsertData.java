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
	admin1.setEmail("admin@email.com");
	admin1.setLastName("Uniovi");
	admin1.setName("Admin");
	admin1.setPassword("admin");
	admin1.setPasswordConfirm("admin");
	admin1.setRole(Role.ROLE_ADMIN);
	us.addUser(admin1);
	
	
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
	
	User user4 = new User();
	user4.setEmail("pablo@uniovi.es");
	user4.setLastName("Uniovi");
	user4.setName("Pablo");
	user4.setPassword("user123");
	user4.setPasswordConfirm("user123");
	user4.setMoney(100.0);
	user4.setRole(Role.ROLE_STAND);
	us.addUser(user4);
	
	User user5 = new User();
	user5.setEmail("chocolatesPaco@gmail.com");
	user5.setLastName("Muñoz");
	user5.setName("Paco");
	user5.setPassword("user123");
	user5.setPasswordConfirm("user123");
	user5.setMoney(100.0);
	user5.setRole(Role.ROLE_STAND);
	us.addUser(user5);
	
	User user6 = new User();
	user6.setEmail("danielLlana_98@gmail.com");
	user6.setLastName("Llana");
	user6.setName("Daniel");
	user6.setPassword("user123");
	user6.setPasswordConfirm("user123");
	user6.setMoney(100.0);
	user6.setRole(Role.ROLE_STAND);
	us.addUser(user6);
	
	User user7 = new User();
	user7.setEmail("davidFandos@gmail.com");
	user7.setLastName("Fandos");
	user7.setName("David");
	user7.setPassword("user123");
	user7.setPasswordConfirm("user123");
	user7.setMoney(100.0);
	user7.setRole(Role.ROLE_STAND);
	us.addUser(user7);
	
	
	ss.add(new Sale("Raqueta de tenis Babolat", "Con cordajes y grips recambiables", 90.00), user1);
	ss.add(new Sale("Set de discos olímpicos Eleiko", "10, 15 y 20 kg", 80), user1);
	ss.add(new Sale("Fin de semana en una casa rural en Soria", "Con piscina y jardín", 70), user1);
	ss.add(new Sale("Seat Panda", "Un coche", 20000.00), user2);
	ss.add(new Sale("Película Dolor y Dinero", "Película del director Michael Bay", 10.0), user2);
	ss.add(new Sale("Carcasa de pugs para móvil", "Disponible para Xiaomi y Apple", 5.00), user2);
	ss.add(new Sale("Set de dinosaurios de juguete", "Fantásticos para pasar el día en familia", 100.00), user3);
	ss.add(new Sale("Pórtatil Acer", "No funciona bien y es rojo", 700.00), user3);
	ss.add(new Sale("Reloj de cuco", "Sale el cuco cada hora", 90.00), user1);
	ss.add(new Sale("Salvar al soldado Ryan", "Película de la segunda guerra mundial", 80), user1);
	ss.add(new Sale("Camiseta Powerexplosive", "Perfecta para entrenar", 20.00), user1);
	ss.add(new Sale("Disco de ACDC Back in Black", "Emblemático disco de la banda de Hard Rock", 15.00), user1);
	ss.add(new Sale("Gladiator", "Película sobre el imperio romano", 10.0), user2);
	ss.add(new Sale("Pulp Fiction", "Película clásica", 5.00), user2);
	ss.add(new Sale("Cronómetro", "Con opciones de hora", 15.00), user3);
	ss.add(new Sale("Cargador de portátil Acer", "Funciona a veces", 20.00), user3);
	ss.add(new Sale("Zapatillas adidas", "Perfectas para correr e ir al gimnasio", 30.00), user3);
	ss.add(new Sale("Camiseta de Ronaldo", "Camiseta de Cristiano Ronaldo de la Juventus", 50.00), user4);
	ss.add(new Sale("Camiseta de Messi", "Camiseta de Lionel Messi en el FCB", 50.00), user4);
	ss.add(new Sale("Botas de futbol adidas", "Botas para jugar al futbol en cesped", 35.00), user4);
	ss.add(new Sale("Balon antiguo", "Pelota de futbol antigua pero en perfecto estado", 10.00), user4);
	ss.add(new Sale("Libro Codigo Da Vinci", "Novela icónica de drama", 10.00), user5);
	ss.add(new Sale("Movil Xiaomi", "Xiaomi Redmi Note 6 Pro", 100.00), user5);
	ss.add(new Sale("IPhone 6", "IPhone 6 en perfecto estado", 200.00), user5);
	ss.add(new Sale("Carcasa IPhone 6", "Carcasa roja para IPhone 6 de goma", 5.00), user5);
	ss.add(new Sale("Cascos IPhone", "Solo se oye el derecho", 3.00), user6);
	ss.add(new Sale("Poster Breaking Bad", "Poster del logo de Breaking Bad", 10.00), user6);
	ss.add(new Sale("Abrigo Pull and Bear", "Abrigo para el invierno", 30.00), user6);
	ss.add(new Sale("Caja sorpresa", "El contenido de la caja es un secreto", 8.00), user6);
	ss.add(new Sale("Cadena de oro", "Cadenita muy crema", 60.00), user7);
	ss.add(new Sale("Anillos de oro", "Anillitos tambien muy crema", 40.00), user7);
	ss.add(new Sale("Camiseta de los lakers", "Cami to guapa", 60.00), user7);
	
    }
    
}
