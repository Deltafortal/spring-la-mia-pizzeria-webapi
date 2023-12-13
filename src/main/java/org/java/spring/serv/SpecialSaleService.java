package org.java.spring.serv;

import java.util.List;

import org.java.spring.pojo.SpecialSale;
import org.java.spring.repo.SpecialSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialSaleService {

	
	@Autowired
	private SpecialSaleRepository specialSaleRepository;
	
	
	
	public List<SpecialSale> findAll() {
		
		return specialSaleRepository.findAll();
	}
	
	
	public SpecialSale findById(int id) {
		
		return specialSaleRepository.findById(id).get();
	}
	
	
	public void save(SpecialSale specialSale) {
		
		specialSaleRepository.save(specialSale);
	}
	
	
	public void delete(SpecialSale specialSale) {
		
		specialSaleRepository.delete(specialSale);
	}
}
