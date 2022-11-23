package controllers.dto;

import models.entities.Address;

public class EvaluatorDTO {
    private int id;
    private String name, cpf, email, senha;
    private Address address;
   
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public Address getAddress() {
        return address;
    }
    
    public void setId(int id) {
       if (id > 0) {
          this.id = id;
       }
    }

    public void setName(String name) {
       if (name != null && !name.isEmpty()) {
           this.name = name;
       }
    }

    public void setCpf(String cpf) {
        if(cpf != null && !cpf.isEmpty()){
            this.cpf = cpf;
        }
    }
    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }
     }
    public void setSenha(String senha) {
        if (senha != null && !senha.isEmpty()) {
            this.senha = senha;
        }
     }
    public void setAddress(Address address) {
        this.address = address;
    }
}
