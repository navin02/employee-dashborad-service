package com.ns.employee.employeeservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "employee-data-service")
public interface EmployeeServiceProxy {
	@Async
	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> listAllEmployees();

	@Async
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEmployeeById(@PathVariable(value="id") String id);

	@Async
	@RequestMapping(value = "/address/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAddressById(@PathVariable(value="id") String id);

	@Async
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable(value="id") String id);

	@Async
	@RequestMapping(value = "/employees", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAllUser();

}
