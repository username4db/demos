package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class One2OneA {

	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_O2O_A", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private Long id;

	@Column(length = 20)
	private String name;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private One2OneB one2;

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

	public One2OneB getOne2() {
		return one2;
	}

	public void setOne2(One2OneB one2) {
		this.one2 = one2;
	}
}