package com.sample.service;

import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.DokazRoot;
import com.sample.repository.DokazRootRepository;

@Service
public class DokazRootService {

	@Autowired
	private DokazRootRepository dokazRootRepository;
	

	
	public Optional<DokazRoot> findById(Long id){
		return dokazRootRepository.findById(id);

	public DokazRoot save(DokazRoot dokazRoot) {
		return dokazRootRepository.save(dokazRoot);
	}
	
	public List<DokazRoot> findAll() {
		return dokazRootRepository.findAll();

	}
}
