package com.uniovi.entities;

import java.util.HashSet;
import java.util.Set; //A collection that contains no duplicate elements

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.uniovi.entities.types.Rol;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String dni;
	private String name;
	private String lastName;
	private String password;

	@Transient // propiedad que no se almacena en la tabla.
	private String passwordConfirm;
	private double money;

	@Enumerated(EnumType.STRING)
	private Rol role;
	private boolean valid;

	@OneToMany(mappedBy = "owner")
	private Set<Sale> publishedSales = new HashSet<>();

	@OneToMany(mappedBy = "buyer")
	private Set<Sale> boughtSales = new HashSet<>();

	@OneToMany(mappedBy = "sender")
	private Set<Message> sentMessages = new HashSet<>();

	@OneToMany(mappedBy = "receiver")
	private Set<Message> receivedMessages = new HashSet<>();

	public User() {
	}

	public long getId() {
		return id;
	}


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return this.name + " " + this.lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Rol getRole() {
		return role;
	}

	public void setRole(Rol role) {
		this.role = role;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Set<Sale> getPublishedSales() {
		return publishedSales;
	}

	public void setPublishedSales(Set<Sale> publishedSales) {
		this.publishedSales = publishedSales;
	}

	public Set<Sale> getBoughtSales() {
		return boughtSales;
	}

	public void setBoughtSales(Set<Sale> boughtSales) {
		this.boughtSales = boughtSales;
	}

	public Set<Message> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(Set<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public Set<Message> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(Set<Message> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

}