package com.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.DokazLeaf;
import com.sample.repository.DokazLeafRepository;

@Service
public class DokazLeafService {

	@Autowired
	public DokazLeafRepository dokazLeafRepository;
	
	public List<DokazLeaf> findAll(){
		return dokazLeafRepository.findAll();
	}
	
	public Optional<DokazLeaf> findById(Long id){
		return dokazLeafRepository.findById(id);
	}
}
