package com.example.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.TestDao;
import com.example.entity.tester.Tester;

@SpringBootTest
public class TesterDaoTest {

	@Autowired
	private TestDao ts;
	
	@Test
	public void getListTester() {
		var t = new Tester();
		t.setName("COCO");
		ts.createTester(t);
	}
	
}
