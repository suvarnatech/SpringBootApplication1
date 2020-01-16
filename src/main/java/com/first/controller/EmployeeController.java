package com.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.first.entity.Employee;
import com.first.util.Util;

@Controller
public class EmployeeController {

	@Autowired
	private CacheManager cache;

	@Autowired
	private Util util;

	@GetMapping("/welcome")
	public ModelAndView showMessage() {
		Employee employee = new Employee();
		employee.setId("123");
		employee.setEmpName("Sukku");
		//System.out.println(util);
	//	System.out.println(util.getId());
		/*
		 * System.out.println(cache.getCache("employee"));
		 * System.out.println(cache.getCacheNames());
		 * System.out.println(cache.getCache("employee").getName());
		 */
		ModelAndView andView = new ModelAndView();
		andView.setViewName("welcome");
		andView.addObject("emp", employee);
		return andView;
	}

	@GetMapping("/register")
	public String showRegistrationPage() {

		return "register";
	}

	@PostMapping("/save")
	@Cacheable(value = "employee", key = "#employees.empName")
	public String saveEmployee(@ModelAttribute Employee employees, ModelMap map) {//@ModelAttribute = @RequestBody, ModelMap = ModelAndView

		map.addAttribute("emp", employees);
		return "welcome";
	}

}
