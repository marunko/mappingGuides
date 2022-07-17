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
	
	@Autowired
	ForTransactionTest testT;
	
	public User_App getUser() {
		  
		return em.find(User_App.class, 1L);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void tra1() {
		  
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
		testT.tra2();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	protected void tra2() {
		  
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName() + " "+TransactionSynchronizationManager.isActualTransactionActive());
	}
	
}
@Component
class ForTransactionTest{
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	protected void tra2() {
		  
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName() + " "+TransactionSynchronizationManager.isActualTransactionActive());
	}
}