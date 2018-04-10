package com.example.webService.RestFullService.Filtering;

import com.fasterxml.jackson.annotation.JsonFilter;


//@JsonIgnoreProperties(value={"password","mobileNo"})
@JsonFilter("Filter")
public class FilteringBean {

	private String userName;
	//@JsonIgnore
	private String password;
	private String mobileNo;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public FilteringBean(String userName, String password, String mobileNo) {
		super();
		this.userName = userName;
		this.password = password;
		this.mobileNo = mobileNo;
	}

}
