package models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "CUSTOMERS")
@Table(name = "CUSTOMERS")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "CUSTOMER_ID", nullable = false)
	private int customer_id;

	@Column(name = "NAME")
	private String name;
	@Column(name = "MAIL")
	private String mail;
	@Embedded

	@AttributeOverrides(value = { @AttributeOverride(name = "THANA", column = @Column),
			@AttributeOverride(name = "LOCATION", column = @Column),
			@AttributeOverride(name = "DIVISION", column = @Column) })
	private Address address;

	public Customer() {
		super();
	}

	public Customer(String name, String mail, Address address) {
		super();
		this.name = name;
		this.mail = mail;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", name=" + name + ", mail=" + mail + ", address=" + address
				+ "]";
	}

}
