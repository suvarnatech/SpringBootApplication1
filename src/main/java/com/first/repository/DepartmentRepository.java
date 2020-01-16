package com.first.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.first.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,String>{

	@Query(" SELECT dept FROM Department dept, Employee emp "
			+ "WHERE dept.dId = emp.department and emp.id =?1")
	public List<Department> findByEmployeeId(String empId);
	
	@Query("SELECT dept FROM Department dept, Employee emp, Address addr "
			+ " WHERE dept.dId = emp.department and"
			+ " emp.id = addr.id and"
			+ " addr.aid =?1 and "
			+ " emp.id =?2 and "
			+ " dept.dId =?3")
	public List<Department> findByEmpIdAndDeptId(String aId, String empId, String detpId);
} 
