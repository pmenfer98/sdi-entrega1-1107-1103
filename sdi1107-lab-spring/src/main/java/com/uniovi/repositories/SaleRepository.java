package com.uniovi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uniovi.entities.Sale;
import com.uniovi.entities.User;
import com.uniovi.entities.types.SaleStatus;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    Page<Sale> findByOwnerAndStatus(Pageable pageable, User user, SaleStatus out);

	Sale getSaleById(Long id);

	/*@Query("SELECT S FROM SALE S " + "WHERE (S.STATUS = 'ON_SALE' OR" + "S.STATUS = 'HIGHLIGHTED') "
			+ "AND S.OWNER.ID !=?1" + "AND S.TITLE LIKE ?2")
	Page<Sale> searchByTitle(Pageable pageable, String text);
	
	@Query("SELECT s FROM Sale s WHERE s.status = 'ONSALE' "
			+ "OR s.status = 'HIGHLIGHTED'")
	Page<Sale> searchAll(Pageable pageable);*/
	
	@Query("SELECT S FROM Sale S WHERE (S.status = 'ON_SALE' OR S.status = 'HIGHLIGHTED' OR S.status = 'SOLD') AND S.owner.id !=?1")
	List<Sale>findOthers(Long id);
	
	List<Sale>findAll();

	
	@Query("SELECT S FROM Sale S"
			+ " WHERE (S.status = 'ON_SALE' OR S.status = 'HIGHLIGHTED')"
					+ " AND S.owner.id != ?2 "
					+ "AND S.title LIKE ?1")
	List<Sale> searchBySaleName(String searchText, Long id);

	@Query("SELECT S FROM Sale S WHERE S.buyer.email = ?1")
	List<Sale> searchBoughtSales(String email);
}
