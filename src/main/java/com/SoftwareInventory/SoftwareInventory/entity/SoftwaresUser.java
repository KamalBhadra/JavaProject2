package com.SoftwareInventory.SoftwareInventory.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "softwares_user")
public class SoftwaresUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "username can not be blank")
	private String softwareusername;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "catagory can not be blank")
	private String softwarecatagory;

	@ManyToOne
	@JoinColumn(name = "catagory_id")
	@JsonManagedReference
	private SoftwaresCatagory softwaresCatagory;

	@ManyToOne
	@JoinTable(name = "user_software", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "software_id"))
	@JsonBackReference
	private Softwares softwares;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private SoftwaresLicense license;
	@JsonIgnore

	public SoftwaresUser(long id, String softwareusername, String softwarecatagory, Softwares softwares,SoftwaresLicense license) {
		super();
		this.id = id;
		this.softwareusername = softwareusername;
		this.softwarecatagory = softwarecatagory;
		this.softwares = softwares;
		this.license=license;
	}

	public SoftwaresUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSoftwareusername() {
		return softwareusername;
	}

	public void setSoftwareusername(String softwareusername) {
		this.softwareusername = softwareusername;
	}

	public String getSoftwarecatagory() {
		return softwarecatagory;
	}

	public void setSoftwarecatagory(String softwarecatagory) {
		this.softwarecatagory = softwarecatagory;
	}

	public SoftwaresCatagory getSoftwaresCatagory() {
		return softwaresCatagory;
	}

	public void setSoftwaresCatagory(SoftwaresCatagory softwaresCatagory) {
		this.softwaresCatagory = softwaresCatagory;
	}

	

	public Softwares getSoftwares() {
		return softwares;
	}

	public void setSoftwares(Softwares softwares) {
		this.softwares = softwares;
	}
	
	

	public SoftwaresLicense getLicense() {
		return license;
	}

	public void setLicense(SoftwaresLicense license) {
		this.license = license;
	}

	@Override
	public String toString() {
		return "SoftwaresUser [id=" + id + ", softwareusername=" + softwareusername + ", softwarecatagory="
				+ softwarecatagory + ", softwaresCatagory=" + softwaresCatagory + ", softwares=" + softwares
				+ ", license=" + license + "]";
	}

}
