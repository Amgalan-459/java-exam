package ru.itstep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Repository
@Transactional
public class MoneyServiceImpl implements MoneyService {
	@Autowired
	private MoneyRepository moneyRepository;
	
	@Override
	public Iterable<Wallet> findAll() {
		return moneyRepository.findAll();
	}

    @Override
	public List<Wallet> findByPurpose(String purpose) {
	    return moneyRepository.findByPurpose(purpose);
	}
    
    @Override
    public List<Wallet> findByQuantityGreaterThanAndQuantityLessThan(Double qmin, Double qmax) {
    	return moneyRepository.findByQuantityGreaterThanAndQuantityLessThan(qmin, qmax);
    }
    
    @Override
    public Wallet save(Wallet w) {
    	return (Wallet) moneyRepository.save(w);
    }

	@Override
	public List<Wallet> findByUserId(Long id) {
		return moneyRepository.findByUserId(id);
	}

	@Override
	public void deleteById(Long id) {
		moneyRepository.deleteById(id);
		
	}

	@Override
	public Wallet findOneById(Long id) {
		return moneyRepository.findOneById(id);
	}

	@Override
	public List<Wallet> findByIsActual(boolean isActual) {
		return moneyRepository.findByIsActual(isActual);
	}

	@Override
	public List<Wallet> findByUserIdAndIsActual(Long id, boolean isActual) {
		return moneyRepository.findByUserIdAndIsActual(id, isActual);
	}
}

