package com.example.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.entity.DemoEntity;
import com.example.demo.repository.DemoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class DemoServiceImplTest {

	private static final Logger LOG = LoggerFactory.getLogger(DemoServiceImplTest.class);

	@TestConfiguration
	static class DemoServiceImplTestContextConfiguration {
		@Bean
		public DemoService employeeService() {
			return new DemoServiceImpl();
		}
	}

	@Autowired
	private DemoService employeeService;

	@MockBean
	private DemoRepository employeeRepository;

	@Before
	public void before() {
		DemoEntity alex = new DemoEntity("alex");
		Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);
	}

	@Test
	public void test() {
		DemoEntity alex = employeeService.getEmployeeByName("bob");
		Assertions.assertThat(alex.getName()).isEqualTo("bob");
	}
}