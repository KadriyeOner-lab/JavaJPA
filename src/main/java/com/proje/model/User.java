package com.proje.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = "User.findById", query = "Select u from User u left join fetch u.userDetail where u.userId= :userId "),
		@NamedQuery(name = "User.findByUsername", query = "Select u from User u where u.Username= :username "),
		@NamedQuery(name = "User.findWithUserDetailByUsername", query = "Select u from User u left join fetch u.userDetail  where u.username= :username "),
		@NamedQuery(name = "User.findUsers", query = "select u from User u"),
		@NamedQuery(name = "User.count", query = "select COUNT(u) from User u"),
		@NamedQuery(name = "User.findUSerInfoByUserName", 
		query = "select new com.proje.model.UserInfo(u.username, u.USerDetail.firstName,u.USerDetail.lastName, u.userDetail.birthOfDate) from User u where u.username=:username") })
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private UserDetail userDetail;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String password, Date creationDate) {
		super();
		this.userName = userName;
		this.password = password;
		this.creationDate = creationDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}
