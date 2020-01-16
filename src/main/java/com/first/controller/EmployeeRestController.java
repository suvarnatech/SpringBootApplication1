package com.first.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app/first/employee")
public class EmployeeRestController {

	@GetMapping
	public ResponseEntity<String> showMessage() {
		return new ResponseEntity<>("Hi Baby",HttpStatus.OK);
	}
}