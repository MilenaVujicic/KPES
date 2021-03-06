package com.sample.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.DokazLeaf;

public interface DokazLeafRepository extends JpaRepository<DokazLeaf, Long> {
	
	Page<DokazLeaf> findAll(Pageable pageable);	
	Optional<DokazLeaf> findById(Long id);
	
	 
}
