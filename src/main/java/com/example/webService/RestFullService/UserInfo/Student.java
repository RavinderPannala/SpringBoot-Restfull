package com.example.webService.RestFullService.UserInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@ApiModel(description="All Student Information")
public class Student {

	private Integer id;
	
	@Size(min=3,message="Name must ba atleast 3 characters")
	@ApiModelProperty(notes="Name must be atleast 3 characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes="Date of birth must be past")
	private Date dob;
	
	private String fees;
	
	private List<Subject> subjects;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Student(Integer id, String name, Date dob, String fees,
			List<Subject> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.fees = fees;
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dob=" + dob
				+ ", fees=" + fees + ", subjects=" + subjects + "]";
	}
	
	


}
