package com.example.webService.RestFullService.Versioning;

public class UserV1 {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserV1() {
		super();
	}

	public UserV1(String name) {
		super();
		this.name = name;
	}

}
