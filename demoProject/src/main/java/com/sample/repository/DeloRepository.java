package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.Delo;

public interface DeloRepository extends JpaRepository<Delo, Long> {
	
}
