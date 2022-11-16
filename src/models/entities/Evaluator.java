package models.entities;

import api.dto.EvaluatorDTO;

public class Evaluator {
    private int id;
    private String nome; 
    private String CPF;
    private Address address;
/*  
    public void Evalutator(String name, String CPF, Address address) {
        this.setName(name);
        this.setCPF(CPF);
        this.setAddress(address);
    }
*/
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
    //.out.println("Endereço Invalido");
      //  }
    }


    @Override
    public String toString() {
        return "Evaluator [name=" + nome + ", CPF=" + CPF + ", address=" + address + "]";
    }
    public static Evaluator converter(EvaluatorDTO dto) {
        Evaluator evaluator = new Evaluator();
        evaluator.setNome(dto.getName());
        evaluator.setId(dto.getId());
        evaluator.setCPF(dto.getCpf());
        evaluator.setAddress(dto.getAddress());
        return evaluator;
    }
    
}

