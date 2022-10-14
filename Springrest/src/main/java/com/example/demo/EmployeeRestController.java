package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmployeeRestController {
@Autowired
	EmployeeDAO dao;
	
//insert
	@PostMapping("/insert")
	public Employee insertrecord( @RequestBody Employee e) {
		return dao.insert(e);
	}
	
	@PostMapping("/insertall")
	public List<Employee> insertallrecord( @RequestBody List<Employee> e) {
		return dao.insertall(e);
	}
	
//finding the details
	
	@GetMapping("/getall")
	public List<Employee> getall(){
		return dao.getall();
	}
	
	@GetMapping("/findbyid/{id}")
	public Optional<Employee> getbyid(@PathVariable int id) throws ResourceNotFoundException {
		if(dao.getbyid(id).isEmpty()) {
			throw new ResourceNotFoundException("id not found");
		
	}
	else {
		return dao.getbyid(id);
	}
	}
	
	
//update
@PutMapping("/update")
public Employee updatebyname(@RequestBody  Employee e) {
	return dao.updatebyname(e);
}

@DeleteMapping("/delete/{id}")
public String delete(@PathVariable int id) {
	return dao.delete(id);
}

@GetMapping("/findbyname/{name}")
public List<Employee> getbyname(@PathVariable String name) throws Exception {
 if(dao.findbyname(name).isEmpty()) {
	 throw new Exception("name not found");
 }
 else {
	 return dao.findbyname(name);
 }
}
}
