package com.SoftwareInventory.SoftwareInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "softwares_vendor")
public class SoftwaresVendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "Vendorname name can not be blank")
	private String vendorname;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "emailid can not be blank")
	private String emailid;

	public SoftwaresVendor(long id, String vendorname, String emailid) {
		super();
		this.id = id;
		this.vendorname = vendorname;
		this.emailid = emailid;
	}

	public SoftwaresVendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Override
	public String toString() {
		return "SoftwaresVendor [id=" + id + ", vendorname=" + vendorname + ", emailid=" + emailid + "]";
	}

}
