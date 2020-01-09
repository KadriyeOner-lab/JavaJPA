package com.proje.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Education.findEducations", query = "select e from Education e"),
		@NamedQuery(name = "Education.findById", query = "select e from Education e where e.eduactionId= :eduactionId"),
		@NamedQuery(name = "Education.findWithAdvertisement", 
		query = "select e from Education e left join fetch e.advertisements where e.educationId= :educationId") })
public class Education implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;

	private String educationName;

	private int lisansYear;

	@ManyToMany(mappedBy = "educations")
	private List<Advertisement> advertisements = new ArrayList<Advertisement>();

	public Education() {
		// TODO Auto-generated constructor stub
	}

	public Education(String educationName, int lisansYear) {
		super();
		this.educationName = educationName;
		this.lisansYear = lisansYear;
	}

	public Integer getEducationId() {
		return educationId;
	}

	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}

	public String getEducationName() {
		return educationName;
	}

	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}

	public int getLisansYear() {
		return lisansYear;
	}

	public void setLisansYear(int lisansYear) {
		this.lisansYear = lisansYear;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

}
