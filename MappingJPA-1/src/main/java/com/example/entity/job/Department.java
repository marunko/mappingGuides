package com.example.entity.job;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="department")
@Data
public class Department {

	@Id
	private long id;
	
	@Column(name="name")
	private String name;
	
	 
	 
	@OneToMany(fetch = FetchType.LAZY ) //or mappedby="department"
	@JoinColumn(referencedColumnName="id")
	private Set<Employee> employees = new HashSet<>();
	/*
	!! Lazy Initialization Exception
	*/
	// LAZY may be initialized by   
	// Middle DTO Entity 
	// Hibernate.Initialize
	
}
