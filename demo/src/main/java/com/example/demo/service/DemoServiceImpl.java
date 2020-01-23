package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DemoEntity;
import com.example.demo.repository.DemoRepository;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoRepository employeeRepository;

	@Override
	public DemoEntity getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public List<DemoEntity> getAllEmployees() {
		return employeeRepository.findAll();
	}
}