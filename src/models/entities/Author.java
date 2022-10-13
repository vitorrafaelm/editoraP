package models.entities;

public class Author {
	private String nome;
	private String adress;
	private String cpf;
	
	public Author(String nome, String adress, String cpf) {
		setNome(nome);
		setAdress(adress);
		setCpf(cpf);
	}

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
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		if(!adress.isEmpty()) {
			this.adress = adress;
		}else { 
			System.out.println("Endere�o Invalido");
		}
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

	public void Cadastro (String status){
		//cadastra um livro
	}
	
	public void Atualizar (Author author) {
		setNome(nome);
		setAdress(adress);
		setCpf(cpf);
	}
	public void Excluir (String status){
		//exclui um livro j� cadastrado
	}
	public String Login (String email) {
		return "";
	}
}