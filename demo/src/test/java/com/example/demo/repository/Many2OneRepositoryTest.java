package com.example.demo.repository;

import java.util.ArrayList;

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

import com.example.demo.entity.Many2OneA;
import com.example.demo.entity.Many2OneB;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class Many2OneRepositoryTest {

	private static final Logger LOG = LoggerFactory.getLogger(Many2OneRepositoryTest.class);

	@Autowired
	private Many2OneARepository repA;

	@Autowired
	private Many2OneBRepository repB;

	@Before
	public void before() {
		LOG.error("===================================================================================");
		LOG.error("===================================================================================");
	}

	@Test
	@Rollback(false)
	public void test() {
		LOG.error("===================================================================================");

		Many2OneB b = new Many2OneB();
		b.setName("B");
		b.setA(new ArrayList<Many2OneA>());

		Many2OneA a = new Many2OneA();
		a.setName("A");
		a.setB(b);
		repA.save(a);

		Many2OneA a2 = new Many2OneA();
		a2.setName("A2");
		a2.setB(b);
		repA.save(a2);

//		b.getA().add(a);
//		b.getA().add(a2);
//		repB.save(b);

		Many2OneA a3 = new Many2OneA();
		a3.setName("A3");
		repA.save(a3);

		Many2OneB b2 = new Many2OneB();
		b2.setName("B2");
		repB.save(b2);

	}

	@Test
	@Rollback(false)
	public void test2() {
		Many2OneB found = repB.findByName("B");
		LOG.error(String.valueOf(found.getId()));
		LOG.error(found.getA() == null ? "NULL" : String.valueOf(found.getA().size()));

		Many2OneB found2 = repB.findByName("B2");
		LOG.error(String.valueOf(found2.getId()));
		LOG.error(found2.getA() == null ? "NULL" : String.valueOf(found2.getA().size()));
		LOG.error("===================================================================================");

		Many2OneA found3 = repA.findByName("A3");
		LOG.error(String.valueOf(found3.getId()));
		LOG.error(found3.getB() == null ? "NULL" : String.valueOf(found3.getB().getId()));
	}
}