package com.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.model.Delo;

public interface DeloRepository extends JpaRepository<Delo, Long> {
	
	@Query("SELECT distinct d from Delo d WHERE d.clan = ?1 AND d.stav = ?2 AND d.tacka = ?3")
	Delo findByClanTackaStav(int clan, int stav, int tacka);
}
