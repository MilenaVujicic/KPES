package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.Delo;
import com.sample.repository.DeloRepository;

@Service
public class DeloService {

	@Autowired
	private DeloRepository deloRepository;
	
	public List<Delo> findAll() {
		return deloRepository.findAll();
	}
  
	public Delo findByClanTackaStav(int clan, int stav, int tacka) {
		return deloRepository.findByClanTackaStav(clan, stav, tacka);
	}

	public Delo save(Delo delo) {
		// TODO Auto-generated method stub
		return deloRepository.save(delo);
	}

}
