package com.first.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.entity.Address;
import com.first.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	public Employee findById(String id);
	
	public List<Employee> findByAddressAidIn(List<String> addrIds);
	
 	public List<Employee> findByAddressAidAndAddressNameAndEmpName(String aid, String aName, String empName);
 	
 	public List<Employee> findByAddressIn(List<Address> allAddress);
}
