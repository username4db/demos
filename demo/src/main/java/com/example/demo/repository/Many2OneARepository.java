package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Many2OneA;

@Repository
public interface Many2OneARepository extends JpaRepository<Many2OneA, Long> {

	public Many2OneA findByName(String name);


}