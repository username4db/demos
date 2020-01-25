package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Many2ManyA;

@Repository
public interface Many2ManyARepository extends JpaRepository<Many2ManyA, Long> {

	public Many2ManyA findByName(String name);


}