package com.example.employeemaster;



public class EmployeeInfo {

	private long id;
	private String firstname;
	private String lastname;
	private String role;
	private long manager;
	private String phone;
	private String email;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String port;

	protected EmployeeInfo() {

	}

	public EmployeeInfo(long id, String firstname, String lastname, String role, long manager, String phone, String email,
			String address1, String address2, String city, String state, String zip, String country,String port) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.manager = manager;
		this.phone = phone;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.port = port;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getManager() {
		return manager;
	}

	public void setManager(long manager) {
		this.manager = manager;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	
}
