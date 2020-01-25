package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Many2ManyA {

	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_M2M_A", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private Long id;

	@Column(length = 20)
	private String name;

	@ManyToMany
	private List<Many2ManyB> b;

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

	public List<Many2ManyB> getB() {
		return b;
	}

	public void setB(List<Many2ManyB> b) {
		this.b = b;
	}
}