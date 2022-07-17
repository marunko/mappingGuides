package com.example.entity.tester;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity 
@Table(name="tester2")
@Data
public class Tester2 {

	@Id
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Override
	public String toString() {
		return name;
	}
}