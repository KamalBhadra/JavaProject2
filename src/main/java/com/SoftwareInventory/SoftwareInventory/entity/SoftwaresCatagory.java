package com.SoftwareInventory.SoftwareInventory.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "software_catagory")
public class SoftwaresCatagory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 30, nullable = false, name = "softwarecatagory")
	@NotBlank(message = "name can not be blank")
	private String name;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "description can not be blank")
	private String description;

	@OneToMany(mappedBy = "catagory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Softwares> softwaresList;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platform_id", referencedColumnName = "id")
    @JsonBackReference
    private SoftwarePlatform softwarePlatform;

	public SoftwaresCatagory(long id, String name, String description, List<Softwares> softwaresList,SoftwarePlatform softwarePlatform) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.softwaresList = softwaresList;
		this.softwarePlatform=softwarePlatform;

	}

	public SoftwaresCatagory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Softwares> getSoftwaresList() {
		return softwaresList;
	}
	

	public void setSoftwaresList(List<Softwares> softwaresList) {
		this.softwaresList = softwaresList;
	}

	public SoftwarePlatform getSoftwarePlatform() {
		return softwarePlatform;
	}

	public void setSoftwarePlatform(SoftwarePlatform softwarePlatform) {
		this.softwarePlatform = softwarePlatform;
	}
	

}
