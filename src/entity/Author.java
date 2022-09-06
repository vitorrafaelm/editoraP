package entity;

public class Author {
private String nome;
private String adress;
private String cpf;

public Author() {
}

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	if(nome != null) {
		this.nome = nome;
	}
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String Cadastro (String status){
	return "";
}

public String Excluir (String status){
	return "";
}
public String Login (String email) {
	return "";
}
}