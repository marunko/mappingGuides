package com.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.entity.manytomany.User_App;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager em;
	
	 
	public User_App getUser() {
		  
		return em.find(User_App.class, 1L);
	}
	
 
	
	
}
 