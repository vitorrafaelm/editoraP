package models.entities;

public class Admin {
	private int id;
	private String name;
	private String email;
	private Address password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getPassword() {
		return password;
	}
	public void setPassword(Address password) {
		this.password = password;
	}
	
	
}

