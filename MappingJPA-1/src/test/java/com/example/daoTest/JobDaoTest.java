package com.example.daoTest;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.JobDao;
import com.example.entity.job.DTOEmployee;
import com.example.entity.job.Department;
import com.example.entity.job.Employee;

@SpringBootTest
public class JobDaoTest {

	@Autowired
	private JobDao jobDao;
	
	  
	
	 @Test
	public void getEmployees() {
		
		jobDao.getEmployees().stream().forEach(x->System.out.println(x.getDepartment().getName() + " " + x.getName()));
	} 
	 /*
	@Test
	public void getDepartments() {
		
		jobDao.getDepartments().stream().forEach(x->System.out.println(x));
	}*/
	 @Test
		public void getEmployee1() {
		 
		DTOEmployee<Employee> em = new DTOEmployee<>(jobDao.getEmployee1(1L));
		
			// System.out.println(jobDao.getEmployee1().getName() + " "+ jobDao.getEmployee1().getDepartment().getName());
		 
		System.out.println(em.toString());
			// System.out.println(em.toString()); toString() cause Lazy Exception or StackOverflow
		}
	@Test
	public void getDepartmentByName() {
		Department d = jobDao.getDepartmentByName("finanace");
		
		System.out.println(d.getName());
		//System.out.println(jobDao.getDepartmentById(1L).getName());
	}
	 
}
