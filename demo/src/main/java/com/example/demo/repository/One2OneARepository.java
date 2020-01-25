package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.One2OneA;

@Repository
public interface One2OneARepository extends JpaRepository<One2OneA, Long> {

	public One2OneA findByName(String name);


}