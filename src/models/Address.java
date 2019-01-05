package models;

import javax.persistence.Column;

public class Address {

	@Column(name = "THANA")
	private String thana;
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "DIVISION")
	private String division;

	public Address() {
		super();
	}

	public Address(String thana, String location, String division) {
		super();
		this.thana = thana;
		this.location = location;
		this.division = division;
	}

	public String getThana() {
		return thana;
	}

	public void setThana(String thana) {
		this.thana = thana;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	@Override
	public String toString() {
		return "Address [thana=" + thana + ", location=" + location + ", division=" + division + "]";
	}

}
