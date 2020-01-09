package com.proje.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.proje.model.util.PhoneType;

@Entity

@NamedQueries({			
			@NamedQuery(name = "UserDetail.findByUsername",
					query = "select ud from UserDetail ud  ud.user u where u.user.username= :username"),
			@NamedQuery(name = "UserDetail.findByuserDetailId",
			query = "select ud from UserDetail ud   where ud.userDetailId= :userDetailId"),
			@NamedQuery(name = "UserDetail.findWithAddressByUsername",
			query = "select ud From UserDetail ud Left join fetch ud.addresses where ud.user.username= :username "),
			@NamedQuery(name = "UserDetail.findWithAddvertisementByUsername",
			query = "select ud from UserDetail ud left jo,n fetch ud.advertisements where ud.user.username= :username")
		})
public class UserDetail implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userDetailId;

	private String firstName;

	private String lastName;

	private Date birthDate;

	@ElementCollection
	@JoinTable(name = "userdetail_phoneNumber", joinColumns = @JoinColumn(name = "userDetailId"))
	@MapKeyColumn(name = "phoneType")
	@Column(name = "phoneNumber")
	private Map<PhoneType, String> phoneNumbers = new HashMap<PhoneType, String>();

	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "userdetail_addres", joinColumns = @JoinColumn(name = "userDetailId"))
	private List<Address> addresses = new ArrayList<Address>();

	@OneToMany(mappedBy = "userDetail")
	private List<Advertisement> advertisements = new ArrayList<Advertisement>();

	@OneToOne(mappedBy = "userDetail", fetch = FetchType.LAZY)
	private User user;

	public UserDetail() {
		// TODO Auto-generated constructor stub
	}

	public UserDetail(String firstName, String lastName, Date birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public Integer getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(Integer userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Map<PhoneType, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
