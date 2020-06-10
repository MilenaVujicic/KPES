package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.LinkT;
import com.sample.repository.LinkTRepository;

@Service
public class LinkTService {

	@Autowired
	private LinkTRepository linkTRepository;
	
	public List<LinkT> findAll(){
		return linkTRepository.findAll();
	}
}
