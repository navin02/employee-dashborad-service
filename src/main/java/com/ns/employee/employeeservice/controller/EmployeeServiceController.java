package com.ns.employee.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeServiceController {

	@Autowired
	EmployeeServiceProxy employeeProxy;

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> listAllEmployees() {
		return employeeProxy.listAllEmployees();
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEmployeeById(@PathVariable(value = "id") String id) {
		return employeeProxy.getEmployeeById(id);
	}

	@RequestMapping(value = "/address/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAddressById(@PathVariable(value = "id") String id) {
		return employeeProxy.getAddressById(id);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") String id) {
		return employeeProxy.deleteUser(id);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAllUser() {
		return employeeProxy.deleteAllUser();
	}
}
