package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class One2OneB {

	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_O2O_B", initialValue = 200, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private Long id;

	@Column(length = 20)
	private String name;

	@OneToOne(cascade = { CascadeType.ALL }, orphanRemoval = false, mappedBy = "b")
	private One2OneA a;

	public One2OneA getA() {
		return a;
	}

	public void setA(One2OneA a) {
		this.a = a;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}