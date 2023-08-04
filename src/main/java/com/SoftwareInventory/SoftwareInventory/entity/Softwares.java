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
@Table(name = "software")
public class Softwares {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 50, nullable = false)
	@NotBlank(message = "name can not be blank")
	private String name;

	@Column(length = 50, nullable = false)
	@NotBlank(message = "Version can not be blank")
	private String version;

	@Column(length = 50, nullable = false)
	@NotBlank(message = "Publisher can not be blank")
	private String publisher;

	@Column(nullable = false)
	private int quantity;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "software_catagoryID", referencedColumnName = "id")
	@JsonBackReference
	private SoftwaresCatagory catagory;

	@OneToMany(mappedBy = "software")
    @JsonManagedReference
    private List<PurchaseLocation> purchaseLocations;
	
	// constructor using fields
	public Softwares(long id, String name, String version, String publisher, int quantity,List<PurchaseLocation> purchaseLocations ) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.publisher = publisher;
		this.quantity = quantity;
		this.purchaseLocations=purchaseLocations;

	}

	public Softwares() {
		super();
		// TODO Auto-generated constructor stub
	}

//Getters and Setters
	public long getId() {
		return id;
	}

//Constructor using super class
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public SoftwaresCatagory getCatagory() {
		return catagory;
	}

	public void setCatagory(SoftwaresCatagory catagory) {
		this.catagory = catagory;

	}
	

	public List<PurchaseLocation> getPurchaseLocations() {
		return purchaseLocations;
	}

	public void setPurchaseLocations(List<PurchaseLocation> purchaseLocations) {
		this.purchaseLocations = purchaseLocations;
	}

	@Override
	public String toString() {
		return "Softwares [id=" + id + ", name=" + name + ", version=" + version + ", publisher=" + publisher
				+ ", quantity=" + quantity + ", catagory=" + catagory + ", purchaseLocations=" + purchaseLocations
				+ "]";
	}

}
