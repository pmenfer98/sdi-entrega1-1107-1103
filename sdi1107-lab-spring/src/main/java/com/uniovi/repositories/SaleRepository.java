package com.uniovi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.uniovi.entities.Sale;
import com.uniovi.entities.User;
import com.uniovi.entities.types.SaleStatus;

public interface SaleRepository extends JpaRepository<Sale, Long>{

    Page<Sale> findByOwnerAndStatus(Pageable pageable, User user, SaleStatus out);

    Sale getSaleById(Long id);
    
}
