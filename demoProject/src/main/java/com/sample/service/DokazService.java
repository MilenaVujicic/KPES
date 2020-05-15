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
}
