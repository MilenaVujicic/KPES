package com.sample.repository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.DokazRoot;


public interface DokazRootRepository extends JpaRepository<DokazRoot, Long>{

	Page<DokazRoot> findAll(Pageable pageable);	
	Optional<DokazRoot> findById(Long id);

}
