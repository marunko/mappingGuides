package com.example.entity.job;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.entity.manytomany.User_App;
import com.fasterxml.jackson.annotation.JsonIgnore;
 
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="department")
@Getter
@Setter // @Data and Overrides of toString and hashcode throws StackOverflow
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.REFRESH) //or mappedby="department"
	@JoinColumn(referencedColumnName="id")
	private Set<Employee> employees = new HashSet();
	/*
	!! Lazy Initialization Exception
	*/
	// LAZY may be initialized by 
	@Override
	public String toString() {
		return this.name;
	}
	
}
