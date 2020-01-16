package com.first.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.first.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

	@Query(" SELECT addr FROM Address addr WHERE addr.employee.id in ?1")
	public List<Address> findAllEmployess(List<String> empIds);
	
	public List<Address> findByEmployeeIdIn(List<String> empIds);
	
	public List<Address> findByName(String empName);
	
	public List<Address> findByNameAndEmployeeEmpName(String addreName,String empName);
}

 