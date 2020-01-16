package com.first;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.CacheManager;

import com.first.entity.Address;
import com.first.entity.Department;
import com.first.entity.Employee;
import com.first.repository.AddressRepository;
import com.first.repository.DepartmentRepository;
import com.first.repository.EmployeeRepository;
import com.first.util.Util;

@SpringBootApplication
public class FirstApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private Util util;
	

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		//System.out.println(dataSource);
		

		
		//saveEmployee();
		/*
		 * System.out.println(employeeRepository.findAll());
		 * System.out.println(dataSource); System.out.println(cacheManager);
		 * System.out.println(cacheManager.getCacheNames());
		 * System.out.println(cacheManager.getCache("employee"));
		 */
//		getAddress();
		// getEmployees();
		// saveDepartment();
		//getDepartment();
	}

	private void getDepartment() {
		List<Employee> employeesList = employeeRepository.findAll();
		System.out.println(employeesList.get(0).getId());
		List<Address> addressesList = addressRepository.findAll();
		System.out.println(addressesList.get(0).getAid());
		List<Department> departmentList = departmentRepository.findAll();
		System.out.println(departmentList.get(0).getDId());
		System.out.println("****************");
		System.out.println(departmentRepository.findByEmployeeId(employeesList.get(0).getId()));
		System.out.println("****************");
		System.out.println(departmentRepository.findByEmpIdAndDeptId(addressesList.get(0).getAid(), employeesList.get(0).getId(), departmentList.get(0).getDId()));
	}

	private void saveDepartment() {
		Department department = new Department();
		department.setDId(util.getId());
		department.setDName("GE-Design");
		departmentRepository.save(department);

	}

	private void getAddress() {
		List<String> empIds = Arrays.asList("1a251d01-1fa5-48a6-bafd-33268c3e788f",
				"2056d240-0ba2-4aef-908f-2772a74c908a", "a858d7ff-bceb-4f54-8b0e-d671dda078a9");
		System.out.println(addressRepository.findAllEmployess(empIds));
		System.out.println("*****************");
		System.out.println(addressRepository.findByEmployeeIdIn(empIds));
		System.out.println("************************");
		System.out.println(addressRepository.findByName("Hyd"));
		System.out.println(addressRepository.findByNameAndEmployeeEmpName("Hyd", "Sukku"));

	}

	private void getEmployees() {
		List<Address> addressList = addressRepository.findAll();
		System.out
				.println(employeeRepository
						.findByAddressAidIn(
								addressRepository.findAll().stream().map(Address::getAid).collect(Collectors.toList()))
						.size());
		System.out.println(employeeRepository.findByAddressAidIn(
				addressRepository.findAll().stream().map(Address::getAid).collect(Collectors.toList())));
		Address address = addressList.get(0);
		System.out.println(employeeRepository.findByAddressAidAndAddressNameAndEmpName(address.getAid(),
				address.getName(), "Sukku"));
		System.out.println(employeeRepository.findByAddressIn(addressList));
	}

	private void saveEmployee() {
		Employee employee = new Employee();
		employee.setId(util.getId());
		employee.setEmpName("Sukku");
		Address address = new Address();
		address.setEmployee(employee);
		address.setAid(util.getId());
		address.setName("Hyd");
		address.setPhoneNumber("123456789");
		employee.setAddress(Arrays.asList(address));

		// employeeRepository.save(employee);

	}

}
