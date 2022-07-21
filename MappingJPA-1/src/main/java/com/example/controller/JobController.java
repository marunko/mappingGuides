package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.JobDao;
import com.example.entity.job.Department;
import com.example.entity.job.Employee;


@RestController
public class JobController {

	@Autowired
	private JobDao dao;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> list = dao.getEmployees();
		return list != null? new ResponseEntity<>(list,HttpStatus.OK)
				:
					new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/employee1")
	public ResponseEntity<Employee> getEmployee1(){
		 Employee employee = dao.getEmployee1(1L);
		return employee != null? new ResponseEntity<>(employee, HttpStatus.OK)
				:
					new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/departments")
	public ResponseEntity<Map<Department, List<Employee>>> getDepartments(){
		Map<Department, List<Employee>> list = dao.getDepartments();
		return list != null? new ResponseEntity<>(list,HttpStatus.OK)
				:
					new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/employee/create")
	public ResponseEntity<String> createOne(@RequestBody Employee employee, @RequestParam String department){
		Employee e =  dao.saveEmployee(employee, department);
		String str = e.getName() + " " + e.getAge() + " "+ e.getSalary() +
				" ";//+e.getDepartment().getName();
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
	@PostMapping("/employee/remove")
	public ResponseEntity<String> removeOne(@RequestParam long id){
		 dao.removeEmployee(id);
		
		return new ResponseEntity<>( HttpStatus.OK);
	}
	@PostMapping("/employee/update")
	public ResponseEntity<String> updateOne(@RequestBody Employee employee, @RequestParam String name, 
			@RequestParam long id){
		
		Employee e = dao.updateEmployee(employee, name, id);
		String str = e.getName() + " " + e.getAge() + " "+ e.getSalary() +
				" ";//+e.getDepartment().getName();
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
}
