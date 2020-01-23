package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.entity.DemoEntity;
import com.example.demo.service.DemoService;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoRestController.class)
public class DemoRestControllerTest {

	private static final Logger LOG = LoggerFactory.getLogger(DemoRestControllerTest.class);

	@Autowired
	private MockMvc mvc;

	@MockBean
	private DemoService service;

	@Test
	public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {
		DemoEntity alex = new DemoEntity("alex");
		DemoEntity bob = new DemoEntity("bob");

		List<DemoEntity> allEmployees = Arrays.asList(alex);
		Mockito.when(service.getAllEmployees()).thenReturn(allEmployees);
		mvc.perform(MockMvcRequestBuilders.get("/demo/list").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is(alex.getName())));
		
	}
}