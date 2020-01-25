package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.One2ManyA;

@Repository
public interface One2ManyARepository extends JpaRepository<One2ManyA, Long> {

	public One2ManyA findByName(String name);


}