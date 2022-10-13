package models.entities;

public class Admin {
    private String name;
    private String password;

    public String getName(){
        return name;
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

    public Admin(String name, String password){
        setName(name);
        setPassword(password);

    }
    
}
