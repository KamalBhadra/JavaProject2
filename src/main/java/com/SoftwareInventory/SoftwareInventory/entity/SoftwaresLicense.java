package com.SoftwareInventory.SoftwareInventory.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "softwares_license")
public class SoftwaresLicense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "licensekey can not be blank")
	private String licensekey;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "date can not be blank")
	private String expdate;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "users can not be blank")
	private String numberofusers;
	
	@OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private SoftwaresUser user;

	
	public SoftwaresLicense(long id, String licensekey, String expdate, String numberofusers,SoftwaresUser user) {
		super();
		this.id = id;
		this.licensekey = licensekey;
		this.expdate = expdate;
		this.numberofusers = numberofusers;
		this.user=user;
	}

	public SoftwaresLicense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLicensekey() {
		return licensekey;
	}

	public void setLicensekey(String licensekey) {
		this.licensekey = licensekey;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

	public String getNumberofusers() {
		return numberofusers;
	}

	public void setNumberofusers(String numberofusers) {
		this.numberofusers = numberofusers;
	}

	public SoftwaresUser getUser() {
		return user;
	}

	public void setUser(SoftwaresUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SoftwaresLicense [id=" + id + ", licensekey=" + licensekey + ", expdate=" + expdate + ", numberofusers="
				+ numberofusers + ", user=" + user + "]";
	}

}
