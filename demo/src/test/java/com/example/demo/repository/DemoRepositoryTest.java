package com.example.demo.repository;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.DemoEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DemoRepositoryTest {

	private static final Logger LOG = LoggerFactory.getLogger(DemoRepositoryTest.class);

	@Autowired
	private DemoRepository demoRepository;

	// @Test
	@Rollback(true)
	public void whenFindByName_thenReturnEmployee() {
		// given
		DemoEntity alex = new DemoEntity("alex");
		demoRepository.save(alex);

		// when
		DemoEntity found = demoRepository.findByName(alex.getName());
		found = demoRepository.findByNameCustomQuery(alex.getName());
	}
}