package com.uniovi.services;

import javax.annotation.PostConstruct;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Sale;
import com.uniovi.entities.User;
import com.uniovi.entities.types.SaleStatus;
import com.uniovi.repositories.SaleRepository;

@Service
public class SalesService {

    @Autowired
    private SaleRepository salesRepository;

    @PostConstruct
    public void init() {
    }

    public void add(Sale sale, User user) {
	sale.setCreationDate(LocalDateTime.now());
	sale.setOwner(user);
	salesRepository.save(sale);
	for (Sale s : salesRepository.findAll()) {
	    System.out.println(s.toString());
	}
    }

    public Page<Sale> findByIdAndStatus(Pageable pageable, User user, SaleStatus out) {
	for (Sale s : salesRepository.findByOwnerAndStatus(pageable, user, out)) {
	    System.out.println(s.toString());
	}
	return salesRepository.findByOwnerAndStatus(pageable, user, out);
    }

    public void delete(Long id) {
	Sale sale = salesRepository.getSaleById(id);
	sale.setStatus(SaleStatus.OUT);
	salesRepository.save(sale);
    }

}
