package com.uniovi.services;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Sale;
import com.uniovi.repositories.SaleRepository;

@Service
public class SalesService {

    @Autowired
    private SaleRepository salesRepository;

    @PostConstruct
    public void init() {
    }
    
    public void add(Sale sale) {
	sale.setDate(LocalDateTime.now());
	salesRepository.save(sale);
    }
    
    
}
