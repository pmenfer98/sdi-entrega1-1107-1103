package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

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
		sale.setCreationDate(LocalDateTime.now());
		sale.setOwner(user);
		salesRepository.save(sale);
		for (Sale s : salesRepository.findAll()) {
			System.out.println(s.toString());
		}
    public Page<Sale> findByIdAndStatus(Pageable pageable, User user, SaleStatus out) {
	for (Sale s : salesRepository.findByOwnerAndStatus(pageable, user, out)) {
	    System.out.println(s.toString());
	}
	return salesRepository.findByOwnerAndStatus(pageable, user, out);
    }

	public List<Sale> findByIdAndStatus(User user, SaleStatus out) {
		for (Sale s : salesRepository.findByOwnerAndStatus(user, out)) {
			System.out.println(s.toString());
		}
		return salesRepository.findByOwnerAndStatus(user, out);
	}

	public void delete(Long id) {
		Sale sale = salesRepository.getSaleById(id);
		sale.setStatus(SaleStatus.OUT);
		salesRepository.save(sale);
	}

	
	  public List<Sale> findOthers(Long id){ List<Sale> sales = salesRepository.findOthers(id); return sales; }
	 

	public List<Sale> findAllSales() {
		List<Sale> sales = salesRepository.findAll();
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
			double money = user.getMoney() - sale.getPrice();
			user.setMoney(money);
			usersRepository.save(user);
			return true;
		}
		return false;
	}

	public List<Sale> findBySaleName(String searchText, Long id) {
		List<Sale> sales = new ArrayList<>();
		searchText = "%"+searchText+"%";
		sales = salesRepository.searchBySaleName(searchText, id);
		return sales;
	}

	public List<Sale> searchBoughtSales(String email) {
		List<Sale> sales = new ArrayList<>();
		sales = salesRepository.searchBoughtSales(email);
		return sales;
		
	}
	
	

}
