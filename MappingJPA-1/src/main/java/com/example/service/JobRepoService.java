package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeRepository;
import com.example.entity.job.Employee;

@Service
public class JobRepoService {

	@Autowired
	private EmployeeRepository repo;
	
	@Transactional
	public Employee getEmployeeById(long id) {
		return repo.getById(id);
	}
}
