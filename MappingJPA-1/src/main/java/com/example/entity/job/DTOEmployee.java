package com.example.entity.job;

public class DTOEmployee<T extends Employee> {

	// private long id;
	String employee_name;
	int age;
	int salary;
	String department_name;
	
	public DTOEmployee(T t){
		employee_name = t.getName();
		age = t.getAge();
		salary = t.getSalary();
		department_name = t.getDepartment().getName();
	}
 
	private DTOEmployee( ){
		
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.employee_name + " " + this.age + " " + this.salary
				+ " " + this.department_name);
		
		return sb.toString();
	}
	
}
