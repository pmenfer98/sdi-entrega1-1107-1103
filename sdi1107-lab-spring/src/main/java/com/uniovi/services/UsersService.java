package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Sale;
import com.uniovi.entities.User;
import com.uniovi.entities.types.Role;
import com.uniovi.repositories.SaleRepository;
import com.uniovi.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private BCryptPasswordEncoder encripter;

	@PostConstruct
	public void init() {
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		usersRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(Long id) {
		return usersRepository.findById(id).get();
	}

	public void addUser(User user) {
		user.setPassword(encripter.encode(user.getPassword()));
		usersRepository.save(user);
	}

	public User getUserByEmail(String email) {
		return usersRepository.findByEmail(email);
	}

	public List<User> findValidStandardUser() {
		return usersRepository.findByValidAndRole(true, Role.ROLE_STAND);
	}

	public void deleteUser(Long id) {
		User user = usersRepository.getOne(id);
		user.getBoughtSales().forEach(x -> x.setBuyer(null));
		user.getPublishedSales().forEach(x -> saleRepository.delete(x));
		usersRepository.deleteById(id);
	}
	



}
