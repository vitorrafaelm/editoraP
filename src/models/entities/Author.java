package models.entities;

public class Author {
    private int id;
    private String nome;
    private String phone;
    private Address address;
    private String cpf;
    
    
    public Author(String nome, String phone, Address address, String cpf) {
        setNome(nome);
        setPhone(phone);
        setAddress(address);
        setCpf(cpf);
    }   
        
    public int getId() {
        return this.id;
    }

    public void setId(int Id){
        if(Id > 0){
            this.id = Id;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(!phone.isEmpty()) { 
            this.phone = phone;
        }else {
            System.out.println("Telefone invalido");
        }
    }

    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        if(!nome.isEmpty()) {
            this.nome = nome;
        }else {
            System.out.println("Nome invalido");
        }
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
        return "Author [name=" + nome + ", phone=" + phone + ", CPF=" + cpf + ", address=" + address + "]";
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
        setAddress(address);
        setCpf(cpf);
    }
    public void Excluir (String status){
        //exclui um livro j  cadastrado
    }
    public String Login (String email) {
        return "";
    }
}