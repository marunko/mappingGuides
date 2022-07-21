package com.example.daoTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.JobDao;
import com.example.entity.job.DTOEmployee;
import com.example.entity.job.Department;
import com.example.entity.job.Employee;

@SpringBootTest
public class JobDaoTest {

	@Autowired
	private JobDao jobDao;
	@Autowired
	private EntityManager em;
	  
	
	// @Test
	public void getEmployees() {
		
		jobDao.getEmployees().stream().forEach(x->System.out.println(x.getDepartment().getName() + " " + x.getName()));
	} 
	 /*
	@Test
	public void getDepartments() {
		
		jobDao.getDepartments().stream().forEach(x->System.out.println(x));
	}*/
	// @Test
		public void getEmployee1() {
		 
		DTOEmployee<Employee> em = new DTOEmployee<>(jobDao.getEmployee1(1L));
		
			// System.out.println(jobDao.getEmployee1().getName() + " "+ jobDao.getEmployee1().getDepartment().getName());
		 
		System.out.println(em.toString());
			// System.out.println(em.toString()); toString() cause Lazy Exception or StackOverflow
		}
	//@Test
	public void getDepartments() {
		 //Department d = jobDao.getDepartmentByName("finanace");
		
		 //System.out.println(d.getId() + d.getName());
		// System.out.println(jobDao.getDepartmentById(1L).getName());
		// List<Department> e = jobDao.getAllDepartments();
			
		 //e.forEach(x-> System.out.println(x.getName()));
		Map<Department, List<Employee>> map = jobDao.getDepartments();
		
		for(Map.Entry<Department, List<Employee>> d : map.entrySet() ) {
		//	System.out.println(d.getKey().getName());
		}
	}
	@Test
	@Transactional
	public void getEmployeeByDepName() {
		 //List<Employee> e = jobDao.getEmployeesByDepartment("finanace");
		
		// e.forEach(x->System.out.println(x.getName()));
		 Department d = em.find(Department.class, 1L);
		 //Hibernate.initialize(d.getEmployees());
		 List<String> names = d.getEmployees().stream().map((s)->
		 {
			 //Hibernate.initialize(s);
			 System.out.println(s.getName());
		 return s.getName();
		 }).toList();
		
		 names.forEach(System.out::println);
	}
	 
}
