package ru.itstep;

import java.util.List;

public interface MoneyService {
	Wallet save(Wallet w);
	Iterable<Wallet>  findAll();
	List<Wallet>  findByPurpose(String purpose);
    List<Wallet>  findByQuantityGreaterThanAndQuantityLessThan(Double qmin, Double qmax);
    List<Wallet> findByUserId(Long id);
    Wallet findOneById(Long id);
    void deleteById(Long id);
    List<Wallet> findByIsActual(boolean isActual);
    List<Wallet> findByUserIdAndIsActual(Long id, boolean isActual);
}

