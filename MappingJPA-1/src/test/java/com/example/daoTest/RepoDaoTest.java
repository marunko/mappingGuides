package com.example.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.service.JobRepoService;

@SpringBootTest
public class RepoDaoTest {

	@Autowired
	private JobRepoService js;
	
	@Test
	public void getEmployeeById() {
		System.out.print(js.getEmployeeById(1L).getName());
		 
	}
}
