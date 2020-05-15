package com.sample.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.Delo;

public interface DeloRepository extends JpaRepository<Delo, Long> {
	Page<Delo> findAll(Pageable pageable);	
}
