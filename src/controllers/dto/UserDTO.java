package controllers.dto;

public class UserDTO {
    private int id; 
    private String name;
    private String email;
    private String password;
    private String taxId;

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
    

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public void setPassword(String password){
        long cont = password.chars().filter(ch -> ch != ' ').count();
        if(cont > 4 && cont < 13){
            this.password = password;
        }
    }
}
