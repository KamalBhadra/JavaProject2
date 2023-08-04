package com.SoftwareInventory.SoftwareInventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "software_purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "order no can not be blank")
	private String orderno;

	@Column(length = 20, nullable = false)
	@NotBlank(message = "Date can not be blank")
	private String date;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "Software name can not be blank")
	private String softwarename;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "software_id", referencedColumnName = "id")
	@JsonManagedReference
	private Softwares software;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "software_userid", referencedColumnName = "id")
	@JsonManagedReference
	private SoftwaresUser softwareuser;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	@JsonIgnore
	private SoftwaresCatagory softwarecategory;

	public Purchase(long id, String orderno, String date, String softwarename, Softwares software,
			SoftwaresUser softwareuser, SoftwaresCatagory softwarecategory) {
		super();
		this.id = id;
		this.orderno = orderno;
		this.date = date;
		this.softwarename = softwarename;
		this.software = software;
		this.softwareuser = softwareuser;
		this.softwarecategory = softwarecategory;

	}

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public SoftwaresUser getSoftwareuser() {
		return softwareuser;
	}

	public void setSoftwareuser(SoftwaresUser softwareuser) {
		this.softwareuser = softwareuser;
	}

	public SoftwaresCatagory getSoftwarecategory() {
		return softwarecategory;
	}

	public void setSoftwarecategory(SoftwaresCatagory softwarecategory) {
		this.softwarecategory = softwarecategory;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", orderno=" + orderno + ", date=" + date + ", softwarename=" + softwarename
				+ ", software=" + software + ", softwareuser=" + softwareuser + ", softwarecategory=" + softwarecategory
				+ "]";
	}

}
