package com.uniovi.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uniovi.entities.types.SaleStatus;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String details;
    private LocalDateTime creationDate;
    private double price;


    @ManyToOne
    private User owner;

    @ManyToOne
    private User buyer;

    @Enumerated(EnumType.STRING)
    private SaleStatus status = SaleStatus.ON_SALE;

    private String dateString;

    public Sale() {

    }

    public Sale(String title, String details, double price) {
	this.title = title;
	this.details = details;
	this.price = price;
	setCreationDate(LocalDateTime.now());
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((creationDate == null) ? 0 : creationDate.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Sale other = (Sale) obj;
	if (creationDate == null) {
	    if (other.creationDate != null)
		return false;
	} else if (!creationDate.equals(other.creationDate))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

    public Long getId() {
	return id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getDetails() {
	return details;
    }

    public void setDetails(String details) {
	this.details = details;
    }

    public LocalDateTime getCreationDate() {
	return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
	this.creationDate = creationDate;
	this.dateString = getDateString(creationDate);
    }

    public double getPrice() {
	return price;
    }
    
    public String getDateString() {
	return dateString;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public User getOwner() {
	return owner;
    }

    public void setOwner(User owner) {
	this.owner = owner;
    }

    public SaleStatus getStatus() {
	return status;
    }

    public void setStatus(SaleStatus status) {
	this.status = status;
    }

    public User getBuyer() {
	return buyer;
    }

    public void setBuyer(User buyer) {
	this.buyer = buyer;
    }


    public String getDateString(LocalDateTime creationDate) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	return creationDate.format(formatter);
    }

    @Override
    public String toString() {
	return "Sale [title=" + title + ", creationDate=" + creationDate
		+ ", price=" + price + ", owner=" + owner.getEmail()
		+ ", status=" + status + "]";
    }



}
