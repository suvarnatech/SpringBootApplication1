package com.first.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "ADDRESS")
@ToString
public class Address {

	@Id
	private String aid;
	

	private String name;

	private String phoneNumber;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Employee employee;

}
