package entities;

public class Evaluator {
	private String name; 
	private String CPF;
	private Address address;
	
	public void Evalutator(String name, String CPF, Address address) {
		this.name = name;
		this.CPF = CPF; 
		this.address = address;
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
	
	@Override
	public String toString() {
		return "Evaluator [name=" + name + ", CPF=" + CPF + ", address=" + address + "]";
	}
	
	
}

