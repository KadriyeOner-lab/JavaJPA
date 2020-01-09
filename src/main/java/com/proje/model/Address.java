
package com.proje.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private String road;
	private String postaCode;
	private String city;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String road, String postaCode, String city) {
		super();
		this.street = street;
		this.road = road;
		this.postaCode = postaCode;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getPostaCode() {
		return postaCode;
	}

	public void setPostaCode(String postaCode) {
		this.postaCode = postaCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", road=" + road + ", postaCode=" + postaCode + ", city=" + city + "]";
	}

}
