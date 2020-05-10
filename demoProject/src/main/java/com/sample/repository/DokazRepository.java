package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.Dokaz;

public interface DokazRepository extends JpaRepository<Dokaz, Long> {

}
