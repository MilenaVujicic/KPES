package com.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.LinkD;

public interface LinkDRepository extends JpaRepository<LinkD, Long> {
	
	List<LinkD> findAll();

}
