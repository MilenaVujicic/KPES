package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.LinkD;
import com.sample.repository.LinkDRepository;

@Service
public class LinkDService {

	@Autowired
	private LinkDRepository linkDRepository;

	public List<LinkD> findAll(){
		return linkDRepository.findAll();
	}
}
