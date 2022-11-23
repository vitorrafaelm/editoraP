package models.entities;

import controllers.dto.EvaluatorDTO;
import controllers.dto.UserDTO;

public class Evaluator {
    private int id;
    private String nome; 
    private String CPF;
    private Address address;
    private String email;
    private String password;

    public int getId(){
        return this.id;
    }

    public void setId(int Id){
        if(Id > 0){
            this.id = Id;
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

    public String getCPF() {
        return this.CPF;
    }
    public void setCPF(String cpf) {
        if(!cpf.isBlank()) {
            this.CPF = cpf;
        }else {
            System.out.println("CPF invalido");
        }
    }
    
    public Address getAdress() {
        return address;
    }
    
    public void setAddress(Address address) {
     //   if(!address.getId().isEmpty()) {
            this.address = address;
 //       }else { 
    //.out.println("EndereÃ§o Invalido");
      //  }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return nome;
    }
    public static Evaluator converter(EvaluatorDTO dto) {
        Evaluator evaluator = new Evaluator();
        evaluator.setNome(dto.getName());
        evaluator.setId(dto.getId());
        evaluator.setCPF(dto.getCpf());
        evaluator.setAddress(dto.getAddress());
        evaluator.setEmail(dto.getEmail());
        evaluator.setPassword(dto.getSenha());
        return evaluator;
    }
    
    public static Evaluator converter(UserDTO dto) {
        Evaluator evaluator = new Evaluator();
        evaluator.setEmail(dto.getEmail());
        evaluator.setPassword(dto.getPassword());
        return evaluator;
    }
}

