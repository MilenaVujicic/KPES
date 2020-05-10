package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.Obelezje;
import com.sample.repository.ObelezjeRepository;

@Service
public class ObelezjeService {

	@Autowired
	public ObelezjeRepository obelezjeRepository;
	
	public List<Obelezje> findAll() {
		return obelezjeRepository.findAll();
	}
}
