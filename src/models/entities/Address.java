package models.entities;

import controllers.dto.AddressDTO;

public class Address {
	private String street, neightboohood, number, zipcode, city;
	private int id;
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeightboohood() {
		return this.neightboohood;
	}

	public void setNeightboohood(String neightboohood) {
		this.neightboohood = neightboohood;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return this.street + ", " + this.neightboohood + ", " + this.number
				+ ", " + this.city;
	} 
	
	public static Address converter(AddressDTO dto) {
		Address address = new Address();
		address.setStreet(dto.getStreet());
		address.setNeightboohood(dto.getNeightboohood());
		address.setNumber(dto.getNumber());
		address.setZipcode(dto.getZipcode());
		address.setCity(dto.getCity());
		address.setId(dto.getId());
		return address;
	}
	
}
