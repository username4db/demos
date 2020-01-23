package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DemoEntity;

@Service
public interface DemoService {

	public DemoEntity getEmployeeByName(String name);

	public List<DemoEntity> getAllEmployees();
}