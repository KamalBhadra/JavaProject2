package com.SoftwareInventory.SoftwareInventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "purchase_location")
public class PurchaseLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "city can not be blank")
	private String city;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "Personname can not be blank")
	private String personname;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "orderdetails can not be blank")
	private String orderdetails;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "softwarename can not be blank")
	private String softwarename;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "software_id")
	@JsonIgnore
	private Softwares software;

	public PurchaseLocation(long id, String city, String personname, String orderdetails, String softwarename,
			Softwares software) {
		super();
		this.id = id;
		this.city = city;
		this.personname = personname;
		this.orderdetails = orderdetails;
		this.softwarename = softwarename;
		this.software = software;

	}

	public PurchaseLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public String getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(String orderdetails) {
		this.orderdetails = orderdetails;
	}

	public String getSoftwarename() {
		return softwarename;
	}

	public void setSoftwarename(String softwarename) {
		this.softwarename = softwarename;
	}

	public Softwares getSoftware() {
		return software;
	}

	public void setSoftware(Softwares software) {
		this.software = software;
	}

	@Override
	public String toString() {
		return "PurchaseLocation [id=" + id + ", city=" + city + ", personname=" + personname + ", orderdetails="
				+ orderdetails + ", softwarename=" + softwarename + ", software=" + software + "]";
	}

}
