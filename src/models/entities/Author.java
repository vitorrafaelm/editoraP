package models.entities;

import controllers.dto.AddressDTO;
import controllers.dto.AuthorDTO;

public class Author {
	private String nome;
	private Address adress;
	private String cpf;

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(!nome.isEmpty()) {
			this.nome = nome;
		}else {
			System.out.println("Nome invalido");
		}
	}
	public Address getAdress() {
		return adress;
	}
	
	public void setAdress(Address adress) {
//		if(!adress.getId().isEmpty()) {
			this.adress = adress;
//		}else { 
//			System.out.println("Endere�o Invalido");
//		}
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if(!cpf.isBlank()) {
			this.cpf = cpf;
		}else {
			System.out.println("CPF invalido");
		}
	}
	
	public static Author converter(AuthorDTO dto) {
		Author author = new Author();
		author.setNome(dto.getName());
		author.setCpf(dto.getCpf());
		author.setAdress(dto.getAddress());
		return author;
	}
}