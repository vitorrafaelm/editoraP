package models.entities;

public class Address {
	private String id, street, neightboohood, number, zipcode;
	
	public Address(String id, String street, String neightboohood, String number, String zipcode) {
		super();
		this.setId(id);
		this.setNeightboohood(neightboohood);
		this.setNumber(number);
		this.setStreet(street);
		this.setZipcode(zipcode);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", neightboohood=" + neightboohood + ", number=" + number
				+ ", zipcode=" + zipcode + "]";
	} 
	
}
