package com.uniovi.services;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Sale;
import com.uniovi.entities.User;
import com.uniovi.entities.types.SaleStatus;
import com.uniovi.repositories.SaleRepository;
import com.uniovi.repositories.UsersRepository;

@Service
public class SalesService {

    @Autowired
    private SaleRepository salesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @PostConstruct
    public void init() {
    }

    public void add(Sale sale, User user) {
	sale.setOwner(user);
	salesRepository.save(sale);
	for (Sale s : salesRepository.findAll()) {
	    System.out.println(s.toString());
	}
    }

    public Page<Sale> findByIdAndStatus(Pageable pageable, User user,
	    SaleStatus out) {
	for (Sale s : salesRepository.findByOwnerAndStatus(pageable, user,
		out)) {
	}
	return salesRepository.findByOwnerAndStatus(pageable, user, out);
    }

//	public List<Sale> findByIdAndStatus(User user, SaleStatus out) {
//		for (Sale s : salesRepository.findByOwnerAndStatus(user, out)) {
//			System.out.println(s.toString());
//		}
//		return salesRepository.findByOwnerAndStatus(user, out);
//	}

    public void delete(Long id) {
	Sale sale = salesRepository.getSaleById(id);
	sale.setStatus(SaleStatus.OUT);
	salesRepository.save(sale);
    }

    public Page<Sale> findOthers(Pageable pageable, Long id) {
	Page<Sale> sales = salesRepository.findOthers(pageable,id);
	return sales;
    }

    public Page<Sale> findAllSales(Pageable pageable) {
	Page<Sale> sales = salesRepository.findAll(pageable);
	return sales;
    }

    public Sale findById(Long id) {
	Sale sale = salesRepository.getOne(id);
	return sale;
    }

    public boolean buy(Sale sale, User user) {
	if (sale.getBuyer() == null && user.getMoney() >= sale.getPrice()) {
	    sale.setBuyer(user);
	    sale.setStatus(SaleStatus.SOLD);
	    salesRepository.save(sale);
	    double moneyBuyer = user.getMoney() - sale.getPrice();
	    double moneySeller = sale.getOwner().getMoney() + sale.getPrice();
	    user.setMoney(moneyBuyer);
	    sale.getOwner().setMoney(moneySeller);
	    usersRepository.save(sale.getOwner());
	    usersRepository.save(user);
	    return true;
	}
	return false;
    }

    public Page<Sale> findBySaleName(Pageable pageable, String searchText, Long id) {
	searchText = "%" + searchText + "%";
	Page<Sale> sales = salesRepository.searchBySaleName(pageable, searchText, id);
	return sales;
    }

    public Page<Sale> searchBoughtSales(Pageable pageable, String email) {
	Page<Sale> sales = salesRepository.searchBoughtSales(pageable, email);
	return sales;

    }

}
