package controllers.dto;

import models.entities.Address;

public class EvaluatorDTO {

    private String name, cpf;
    private Address address;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        //this.address = address;
    }
}
