package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniovi.entities.Sale;
import com.uniovi.entities.User;
import com.uniovi.entities.types.SaleStatus;

public interface SaleRepository extends JpaRepository<Sale, Long>{

    List<Sale> findByOwnerAndStatus(User user, SaleStatus out);

    Sale getSaleById(Long id);
    
}
