package com.first.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "DEPT")
public class Department {

	@Id
	private String dId;
	
	private String dName;
	
	

}
