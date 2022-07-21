package com.example.daoTest;

import java.io.PrintStream;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.entity.manytomany.Role_App;
import com.example.entity.manytomany.User_App;
import com.example.service.UserRoleService;

@SpringBootTest
public class UserRoleTestRepo {
	static PrintStream p = System.out;
	@Autowired
	UserRoleService s;
	@Autowired
	UserDao dao;
	@PersistenceContext
	private EntityManager em;
	
	//@Test
	public void getOneUser() {
		  p.println(s.getUserById(1L).getPassword());
	}
	//@Test
	public void getOneUser2() {
		p.println(dao.getUser().getEnabled());
	}
	
	@Test
	@Transactional
	public void masterTest1() {
		//p.println(em.find(User_App.class, 1L).getName());
		// List<Role_App> s = em.find(User_App.class, 1L).getRoles().stream().toList();//forEach(x->x.getName());
		// p.println(s.get(0).getName());
		
		em.find(User_App.class, 3L).getRoles().stream().forEach(x->p.println(x.getName()));
	}
	
	 
}
