package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DemoEntity;
import com.example.demo.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoRestController {

	@Autowired
	private DemoService employeeService;

	@GetMapping("/list")
	public List<DemoEntity> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
}