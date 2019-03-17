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
    	
    	Sale sale1 = new Sale("Raqueta de tenis Babolat", "Con cordajes y grips recambiables", 90.00);
    	Sale sale2 = new Sale("Set de discos olímpicos Eleiko", "10, 15 y 20 kg", 80);
    	Sale sale3 = new Sale("Fin de semana en una casa rural en Soria", "Con piscina y jardín", 70);
    	Sale sale4 = new Sale("Seat Panda", "Un coche", 20000.00);
    	Sale sale5 = new Sale("Película Dolor y Dinero", "Película del director Michael Bay", 10.0);
    	Sale sale6 = new Sale("Carcasa de pugs para móvil", "Disponible para Xiaomi y Apple", 5.00);
    	Sale sale7 = new Sale("Set de dinosaurios de juguete", "Fantásticos para pasar el día en familia", 100.00);
    	Sale sale8 = new Sale("Pórtatil Acer", "No funciona bien y es rojo", 700.00);
    	Sale sale9 = new Sale("Reloj de cuco", "Sale el cuco cada hora", 90.00);
    	Sale sale10 = new Sale("Salvar al soldado Ryan", "Película de la segunda guerra mundial", 80);
    	Sale sale11 = new Sale("Camiseta Powerexplosive", "Perfecta para entrenar", 20.00);
    	Sale sale12 = new Sale("Disco de ACDC Back in Black", "Emblemático disco de la banda de Hard Rock", 15.00);
    	Sale sale13 = new Sale("Gladiator", "Película sobre el imperio romano", 10.0);
    	Sale sale14 = new Sale("Pulp Fiction", "Película clásica", 5.00);
    	Sale sale15 = new Sale("Cronómetro", "Con opciones de hora", 15.00);
    	Sale sale16 = new Sale("Cargador de portátil Acer", "Funciona a veces", 20.00);
    	Sale sale17 = new Sale("Zapatillas adidas", "Perfectas para correr e ir al gimnasio", 30.00);
    	Sale sale18 = new Sale("Camiseta de Ronaldo", "Camiseta de Cristiano Ronaldo de la Juventus", 50.00);
    	Sale sale19 = new Sale("Camiseta de Messi", "Camiseta de Lionel Messi en el FCB", 50.00);
    	Sale sale20 = new Sale("Botas de futbol adidas", "Botas para jugar al futbol en cesped", 35.00);
    	Sale sale21 = new Sale("Balon antiguo", "Pelota de futbol antigua pero en perfecto estado", 10.00);
    	Sale sale22 = new Sale("Libro Codigo Da Vinci", "Novela icónica de drama", 10.00);
    	Sale sale23 = new Sale("Movil Xiaomi", "Xiaomi Redmi Note 6 Pro", 100.00);
    	Sale sale24 = new Sale("IPhone 6", "IPhone 6 en perfecto estado", 200.00);
    	Sale sale25 = new Sale("Carcasa IPhone 6", "Carcasa roja para IPhone 6 de goma", 5.00);
    	Sale sale26 = new Sale("Cascos IPhone", "Solo se oye el derecho", 3.00);
    	Sale sale27 = new Sale("Poster Breaking Bad", "Poster del logo de Breaking Bad", 10.00);
    	Sale sale28 = new Sale("Abrigo Pull and Bear", "Abrigo para el invierno", 30.00);
    	Sale sale29 = new Sale("Caja sorpresa", "El contenido de la caja es un secreto", 8.00);
    	Sale sale30 = new Sale("Cadena de oro", "Cadenita muy crema", 60.00);
    	Sale sale31 = new Sale("Anillos de oro", "Anillitos tambien muy crema", 40.00);
    	Sale sale32 = new Sale("Camiseta de los lakers", "Cami to guapa", 60.00);
    	
    	
    	ss.add(sale1, user1);
    	ss.add(sale2, user1);
    	ss.add(sale3, user1);
    	ss.add(sale4, user2);
    	ss.add(sale5, user2);
    	ss.add(sale6, user2);
    	ss.add(sale7, user3);
    	ss.add(sale8, user3);
    	ss.add(sale9, user1);
    	ss.add(sale10, user1);
    	ss.add(sale11, user1);
    	ss.add(sale12, user1);
    	ss.add(sale13, user2);
    	ss.add(sale14, user2);
    	ss.add(sale15, user3);
    	ss.add(sale16, user3);
    	ss.add(sale17, user3);
    	ss.add(sale18, user4);
    	ss.add(sale19, user4);
    	ss.add(sale20, user4);
    	ss.add(sale21, user4);
    	ss.add(sale22, user5);
    	ss.add(sale23, user5);
    	ss.add(sale24, user5);
    	ss.add(sale25, user5);
    	ss.add(sale26, user6);
    	ss.add(sale27, user6);
    	ss.add(sale28, user6);
    	ss.add(sale29, user6);
    	ss.add(sale30, user7);
    	ss.add(sale31, user7);
    	ss.add(sale32, user7);
    	
    	ss.buy(sale5, user1);
    	ss.buy(sale6, user1);
    	ss.buy(sale11, user2);
    	ss.buy(sale3, user2);
    	ss.buy(sale18, user3);
    	ss.buy(sale20, user3);
    	ss.buy(sale14, user4);
    	ss.buy(sale15, user4);
    	ss.buy(sale26, user5);
    	ss.buy(sale27, user5);
    	ss.buy(sale22, user6);
    	ss.buy(sale25, user6);
    	ss.buy(sale16, user7);
    	ss.buy(sale17, user7);
	
    }
    
}
