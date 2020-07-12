package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DemoDTO;

@RestController
@RequestMapping(value = "/")
public class DemoController {

	@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DemoDTO> hello(RequestEntity<DemoDTO> dto) {
		return ResponseEntity.ok().body(dto.getBody());
	}

	@RequestMapping(value = "/hello2", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DemoDTO hello2(@RequestBody DemoDTO dto) {
		return dto;
	}

}
