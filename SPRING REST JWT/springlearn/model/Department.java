package com.cognizant.springlearn.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Department {
	
	@NotNull
	@Min(value = 1, message = "Department ID should be a positive number")
	private Integer id;
	
	@NotNull
	@NotBlank(message = "Department name cannot be blank")
	@Size(min = 1, max = 30, message = "Department name should be between 1 and 30 characters")
	private String name;
	
	public Department() {
	}
	
	public Department(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
