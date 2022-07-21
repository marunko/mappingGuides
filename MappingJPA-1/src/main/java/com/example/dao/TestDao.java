package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.tester.Tester;

@Repository
public class TestDao {

	@Autowired
	private EntityManagerFactory ef;
	
	@PersistenceContext
	private EntityManager entityManger;
	
	public List<Tester> getTester1()
	{
		EntityManager em = ef.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery();
		Root<Tester> tester = cq.from(Tester.class);
		// cq.select(tester); 
		// cq.where(cb.like(tester.get("name"), "1111111"));
		return em.createQuery(cq.select(tester)).getResultList();
	}
	@Transactional
	public Tester getTesterByName(String name)
	{
		Query query = entityManger.createQuery(" from Tester t WHERE name = :name");
		query.setParameter("name", name);
		return (Tester) query.getSingleResult();
	}
	
	@Transactional
	public void createTester(Tester tester){
		System.out.println(tester.getId());
		 
		Tester t = new Tester();
		// t.setName(tester.getName());
		t = tester;
		entityManger.persist(t);
		entityManger.flush();
		entityManger.close();
	}	
	
	@Transactional
	public void updateTester(String oldname, Tester tester){
		 
	 
		Tester t = this.getTesterByName(oldname);
		t.setName(tester.getName());
		
		entityManger.merge(t);
		entityManger.flush();
		entityManger.close();
	}
	
	@Transactional
	public void removeTester(Long id){ 
		 // !!! Use EM to attach entity to persistence
		Tester t = entityManger.find(Tester.class, id);
		
		entityManger.remove(t);
		//entityManger.flush();
		entityManger.close();
	}
}
