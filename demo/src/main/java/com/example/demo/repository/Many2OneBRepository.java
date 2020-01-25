package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Many2OneB;

@Repository
public interface Many2OneBRepository extends JpaRepository<Many2OneB, Long> {

	public Many2OneB findByName(String name);

}