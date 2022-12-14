package models.entities;

import controllers.dto.AuthorDTO;
import controllers.dto.UserDTO;

public class Admin {
    private int id; 
    private String name;
    private String email;
    private String password;

    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name){
        long strcont = name.chars().filter(ch -> ch != ' ').count();
        if(strcont > 4 && strcont < 30){
            this.name = name;
        }
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        long cont = password.chars().filter(ch -> ch != ' ').count();
        if(cont > 4 && cont < 13){
            this.password = password;
        }
    }
    
    public static Admin converter(UserDTO dto) {
        Admin admin = new Admin();
        admin.setEmail(dto.getEmail());
        admin.setPassword(dto.getPassword());
        return admin;
    }
}
