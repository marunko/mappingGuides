package com.example.daoTest;

import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.UserDao;
import com.example.service.UserRoleService;

@SpringBootTest
public class UserRoleTestRepo {
	static PrintStream p = System.out;
	@Autowired
	UserRoleService s;
	@Autowired
	UserDao dao;
	
	@Test
	public void getOneUser() {
		  p.println(s.getUserById(1L).getPassword());
	}
	@Test
	public void getOneUser2() {
		p.println(dao.getUser().getEnabled());
	}
	 
}
