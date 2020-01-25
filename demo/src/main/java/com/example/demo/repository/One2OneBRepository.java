package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.One2OneB;

@Repository
public interface One2OneBRepository extends JpaRepository<One2OneB, Long> {

	public One2OneB findByName(String name);

}