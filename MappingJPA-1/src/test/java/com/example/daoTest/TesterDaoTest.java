package com.example.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.TestDao;

@SpringBootTest
public class TesterDaoTest {

	@Autowired
	private TestDao ts;
	
	@Test
	public void getListTester() {
		
		System.out.println(ts.getTesterByName("1111111"));
	}
	
}
