package ru.itstep;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface MoneyRepository extends CrudRepository<Wallet, Long> {
	List<Wallet>  findByPurpose(String purpose);
	List<Wallet>  findByQuantityGreaterThanAndQuantityLessThan(Double qmin, Double qmax);
	List<Wallet> findByUserId(Long id);
	Wallet findOneById(Long id);
	void deleteById(Long id);
	List<Wallet> findByIsActual(boolean isActual);
	List<Wallet> findByUserIdAndIsActual(Long id, boolean isActual);
	
	//@Query("select quantity from buy t where t.purpose = ?1")
	//  Wallet findByEmailAddress(String purpose);
	
	//@Modifying
    //@Query(value = "insert into buy (id, purpose, quantity) VALUES (:id,:pur,:qu)", nativeQuery = true)
    //@Transactional
    //void putSmth(@Param("id") Long i, @Param("pur") String purp, @Param("qu") Double quant);
}
