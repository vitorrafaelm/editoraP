package models.entities;

public class Evaluator {
	private int id;
	private String name; 
	private String CPF;
	private Address address;
	
	public void Evalutator(String name, String CPF, Address address) {
		this.setName(name);
		this.setCPF(CPF);
		this.setAddress(address);
	}

	public int getId(){
		return this.id;
	}

	public void setId(int Id){
		if(Id != 0){
			this.id = Id;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if(name.length() > 0) {
			this.name = name;
		}
	}
	
	public String getCPF() {
		return this.CPF;
	}
	
	public boolean setCPF(String cPF) {
		if(cPF.length() == 11) {
			this.CPF = cPF;
			return true;
		}
		
		this.CPF = "";
		return false;
	}
	
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		if(address != null) {
			this.address = address;
		}
	}

	@Override
	public String toString() {
		return "Evaluator [name=" + name + ", CPF=" + CPF + ", address=" + address + "]";
	}
	
	
}

