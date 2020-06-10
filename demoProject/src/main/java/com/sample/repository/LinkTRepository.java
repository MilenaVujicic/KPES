package com.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.LinkT;

public interface LinkTRepository extends JpaRepository<LinkT, Long> {

	List<LinkT> findAll();
}
