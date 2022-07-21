package com.example.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
 

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.job.Department;
import com.example.entity.job.Employee;

@Repository
public class JobDao {

	 
	
	@PersistenceContext
	private EntityManager em;
	
	Logger logger = LoggerFactory.getLogger(JobDao.class);
	
	@Transactional
	public List<Employee> getEmployees(){
		 
		TypedQuery<Employee> query 
	      = em.createQuery(
	          "SELECT e FROM Employee e "
	          + " JOIN FETCH e.department d", Employee.class);
	    List<Employee> resultList = query.getResultList();
	    em.close();
		return resultList;
	}
	
	@Transactional
	public Employee  getEmployee1(Long id){
		logger.info("STARTED EM");
		 
		logger.info("QUERY");
			Query query 
		      = em.createQuery(
		          "SELECT e FROM Employee e "
		          + " JOIN FETCH e.department d WHERE e.id = :id");
			query.setParameter("id", id);
			logger.info("QUERY OVER -> getSingleResult");
		    Employee r = (Employee) query.getSingleResult();
		    logger.info("Hibernate.initialize BFR");
		    Hibernate.initialize(r.getDepartment());
		    logger.info("Hibernate.initialize ATFR");
	    em.close();
	    logger.trace("close");
		return r;
	}
	@Transactional
	public List<Employee> getEmployeesByDepartment(String depName){
		Query query 
	      = em.createQuery(
	          "SELECT e FROM Employee e "
	          + " JOIN FETCH e.department d WHERE d.name = :name");
		query.setParameter("name", depName);
		List<Employee> list = query.getResultList();
		return list;
	}
	
	@Transactional
	public Department getDepartmentByName(String name){
		
		Query query = em.createQuery("SELECT d FROM Department d "
				+ "WHERE d.name LIKE :name");
		query.setParameter("name", name);
		 
		 
		Department department = (Department) query.getSingleResult();
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		// may extract ID and NAME
		 // impossible to extract department.getEmployees(); due to ResultSet format
		/// Use like Map<Department, List<Employee>> 
		
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		return department;			
	}
	@Transactional
	public Department getDepartmentById(Long id){
		Department dep = em.find(Department.class, id);
		// dep.setEmployees(Set.copyOf(getEmployeesByDepartment("finanace")));
		 // System.out.println(dep.getEmployees().size());
		/*for(Employee e : dep.getEmployees())
			Hibernate.initialize(e);*/
		return dep;
	}
	
	@Transactional
	public List<Department> getAllDepartments(){
		// USE DTO typical Entity
		Query query 
	      = em.createQuery( " FROM Department d ");  
		return query.getResultList();
	}
	
	
	@Transactional
	public Map<Department, List<Employee>> getDepartments(){
		// USE DTO typical Entity cause Result set Error
		Map<Department, List<Employee>> m = new HashMap<>();
		 List<Department> list = getAllDepartments();
		 for(Department d : list) {
			 m.put(d, getEmployeesByDepartment(d.getName()));
		 }
		 
		 return m;		
	}
	
	@Transactional
	public Employee saveEmployee(Employee employee, String departmentName){
		 /*
		  * Except department as JSON id + name
		  * 
		  * 
		  * */
		Employee e = new Employee();
		e.setName(employee.getName());
		e.setAge(employee.getAge());
		e.setSalary(employee.getSalary());
		e.setDepartment(employee.getDepartment());
		
		em.persist(e);
		//Employee empl = getEmployee1(e.getId());
		em.flush();
		em.close();
		
		return e;
	}
	@Transactional
	public Employee updateEmployee(Employee employee, String departmentName, long id){
		 
		 
		Employee e = em.find(Employee.class, id);
		e.setName(employee.getName());
		e.setAge(employee.getAge());
		e.setSalary(employee.getSalary());
		e.setDepartment(employee.getDepartment());
		
		em.merge(e);
		//Employee empl = getEmployee1(e.getId());
		em.flush();
		em.close();
		
		return e;
	}
	 
	@Transactional 
	public void removeEmployee(long id) {
		
		Employee e = em.find(Employee.class, id);
		em.remove(e);
		em.close();
	}
 
	
	
}
