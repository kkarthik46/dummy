package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeeDAO {

	//creation of reference 
	@Autowired
	EmployeeRepository repo;
	
	
	//insertion 
	public Employee insert(Employee e) {
		return repo.save(e);
	}
	
	
	//insert as a list
	public List<Employee> insertall(List<Employee> e){
		return repo.saveAll(e);
	}
	
	//retrival 
	
	public List<Employee> getall(){
		return repo.findAll();
	}
	
	//by id
	//Optional<Employee> is going to take the return as a single record / multiple list of records
	public Optional<Employee> getbyid(int id) {
		return repo.findById(id);
	}
	
	//delete by id
	public String delete(int id) {
		repo.deleteById(id);
		return "deleted id value"+id;
	}
	//repo.deleteAll();
	
	//update-doesnt have a default method in repo 
	/*we need to fetch the record from the table
	 * we set the value
	 * we save the value into the table 
	 * */
	
	
	//1 karthik k@c.c 23 -table
	//  Ramesh
                                   //1  Ramesh
	public Employee updatebyname(Employee e) {
		//we need to fetch the record from the table
		Employee ee=repo.findById(e.getEmpno()).orElse(null);//ee=>1 karthik k@c.c 23 -table
		ee.setEmpname(e.getEmpname());//ee=>karthik->ramesh
		return repo.save(ee);
	}
	
	
	//findbyname
	public List<Employee> findbyname(String name){
		return repo.findbyname(name);
	}
	
	
	
}
