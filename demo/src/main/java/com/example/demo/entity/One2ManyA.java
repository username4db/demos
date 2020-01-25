package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class One2ManyA {

	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_O2M_A", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private Long id;

	@Column(length = 20)
	private String name;
	
	@OneToMany
	private List<One2ManyB> bs;

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

	public List<One2ManyB> getBs() {
		return bs;
	}

	public void setBs(List<One2ManyB> bs) {
		this.bs = bs;
	}

}