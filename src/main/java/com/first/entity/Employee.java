package com.first.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	private String id;

	private String empName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	private List<Address> address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dId")
	private Department department;

}
