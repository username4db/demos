package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DemoEntity;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Long> {

	public DemoEntity findByName(String name);

	@Query("select u from DemoEntity u where u.name = :p_name")
	public DemoEntity findByNameCustomQuery(@Param("p_name") String name);

}