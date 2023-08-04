package com.SoftwareInventory.SoftwareInventory.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "software_platform")
public class SoftwarePlatform {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length=30,nullable=false)
	@NotBlank(message="platform can not be blank")
	private String platform;
	
	@Column(length=30,nullable=false)
	@NotBlank(message="operating system can not be blank")
	private String operatingsystem;
	
	@OneToMany(mappedBy = "softwarePlatform", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<SoftwaresCatagory> softwareCategories;

	public SoftwarePlatform(long id, String platform, String operatingsystem,List<SoftwaresCatagory> softwareCategories) {
		super();
		this.id = id;
		this.platform = platform;
		this.operatingsystem = operatingsystem;
		this.softwareCategories=softwareCategories;
	}

	public SoftwarePlatform() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getOperatingsystem() {
		return operatingsystem;
	}

	public void setOperatingsystem(String operatingsystem) {
		this.operatingsystem = operatingsystem;
	}
	

	public List<SoftwaresCatagory> getSoftwareCategories() {
		return softwareCategories;
	}

	public void setSoftwareCategories(List<SoftwaresCatagory> softwareCategories) {
		this.softwareCategories = softwareCategories;
	}

	@Override
	public String toString() {
		return "SoftwarePlatform [id=" + id + ", platform=" + platform + ", operatingsystem=" + operatingsystem
				+ ", softwareCategories=" + softwareCategories + "]";
	}

}
