package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.Dokaz;
import com.sample.repository.DokazRepository;

@Service
public class DokazService {

	@Autowired
	DokazRepository dokazRepository;
	
	public List<Dokaz> findAll(){
		return dokazRepository.findAll();
	}

	public Dokaz save(Dokaz dokaz) {
		// TODO Auto-generated method stub
		return dokazRepository.save(dokaz);
	}
}
