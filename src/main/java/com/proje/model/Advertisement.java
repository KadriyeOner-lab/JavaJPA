package com.proje.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = "Advertisement.findById", query = "select a from Advertisement a left join fetch a.eduactions where a.advertisementId= :advertisementId"),
		@NamedQuery(name = "Advertisement.findByUsername", query = "select a from User u left join u.userDetail ud left join ud.advertisements a where u.username=:username"),
		@NamedQuery(name = "Advertisement.findAdvertisements", query = "select a from Advertisement a") })

public class Advertisement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer advertisementId;

	private String title;

	@Lob
	private String workDefinition;

	@Lob
	private String criteria;

	private Date addDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	private boolean enabled = false;

	private Date removeDate;

	@ManyToMany
	@JoinTable(name = "advertisement_education", joinColumns = @JoinColumn(name = "advertisementId"), inverseJoinColumns = @JoinColumn(name = "educationId"))
	private List<Education> educations = new ArrayList<Education>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userDetailId")
	private UserDetail userDetail;

	public Advertisement() {
		// TODO Auto-generated constructor stub
	}

	public Advertisement(String title, String workDefinition, String criteria) {
		super();
		this.title = title;
		this.workDefinition = workDefinition;
		this.criteria = criteria;
	}

	public Integer getAdvertisementId() {
		return advertisementId;
	}

	public void setAdvertisementId(Integer advertisementId) {
		this.advertisementId = advertisementId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkDefinition() {
		return workDefinition;
	}

	public void setWorkDefinition(String workDefinition) {
		this.workDefinition = workDefinition;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getRemoveDate() {
		return removeDate;
	}

	public void setRemoveDate(Date removeDate) {
		this.removeDate = removeDate;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}
