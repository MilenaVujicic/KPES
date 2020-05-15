package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.Tuzilac;
import com.sample.repository.TuzilacRepository;

@Service
public class TuzilacService {

	@Autowired
	TuzilacRepository tuzilacRepository;
	
	public List<Tuzilac> findAll(){
		return tuzilacRepository.findAll();
	}
}
