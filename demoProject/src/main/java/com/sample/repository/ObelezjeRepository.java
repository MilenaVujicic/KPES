package com.sample.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.Obelezje;

public interface ObelezjeRepository extends JpaRepository<Obelezje, Long>{

	Page<Obelezje> findAll(Pageable pageable);	
}
