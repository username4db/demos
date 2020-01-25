package com.example.demo.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.One2OneA;
import com.example.demo.entity.One2OneB;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class One2OneRepositoryTest {

	private static final Logger LOG = LoggerFactory.getLogger(One2OneRepositoryTest.class);

	@Autowired
	private One2OneARepository repA;

	@Autowired
	private One2OneBRepository repB;

	@Before
	@Rollback(false)
	public void before() {
		LOG.error("before");
		One2OneA a = new One2OneA();
		a.setName("A");
		One2OneB b = new One2OneB();
		b.setName("B");
		a.setOne2(b);

		// repB.save(b);
		repA.save(a);
		
		One2OneB b2 = new One2OneB();
		repB.save(b2);
	}

	@Test
	@Rollback(false)
	public void test() {
		LOG.error("test");
		One2OneA found = repA.findByName("A");
		LOG.error(found.getOne2().getName());
	}
}