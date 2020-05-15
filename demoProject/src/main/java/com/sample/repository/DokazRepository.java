package com.sample.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.Dokaz;

public interface DokazRepository extends JpaRepository<Dokaz, Long> {
	Page<Dokaz> findAll(Pageable pageable);	
}
