package com.example.service;

 

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserRepository;
import com.example.entity.manytomany.User_App;

@Service
@Transactional
public class UserRoleService {

	@Autowired
	private UserRepository userRepo;
	
	public User_App getUserById(long id) {
		User_App uapp = userRepo.findById(id).get();
		Hibernate.initialize(uapp.getRoles());
		
		return uapp;
	}
	public User_App saveUser(long id) {
		
		return userRepo.findById(id).get();
	}
}
