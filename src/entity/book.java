package entity;

import java.util.Calendar;

class Book {

    private Author author;
    //private Evaluator evaluator; 
    private String title;
    private String description;
    private String gender;
    private Calendar dateLaunch;
    private String status_register; //aprovado, em analise, nao aprovado

    //constructor que faz o cadastro do livro
    public Book(String title, String description, String gender,  Calendar dateLaunch, Author author) {
        setTitle(title);
        setDescription(description);
        setGender(gender);
        setDateLaunch(dateLaunch);
        this.author = author;
        this.status_register = "em analise";
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGender() {
        return gender;
    }

    public Calendar getDateLaunch() {
        return dateLaunch;
    }
    
    public String getStatus_register() {
        return status_register;
    }

    public Author getAuthor() {
        return author;
    }

    //setters
    public void setDescription(String description) {
        this.description = !description.isEmpty() ? description : "descrição não informada";
    }

    public void setGender(String gender) {
        this.gender = !gender.isEmpty() ? gender : "Genero não informado";
    }

    /**
     * valores permitidos: aprovado, em analise, nao aprovado
     * @param status_register
     */
    public void setStatus_register(String status_register) {

        status_register = status_register.toLowerCase();

        if (
            status_register.compareTo("aprovado") == 0 ||
            status_register.compareTo("analise") == 0 ||
            status_register.compareTo("nao aprovado") == 0
        ) {
            this.status_register = status_register;
        } else {
            this.status_register = "em analise";
            System.out.println("valor invalido de status");
        }
        
    }

    public void setTitle(String title) {
        if (!title.isEmpty())
            this.title = title;
        else 
            System.out.println("O titulo nao pode ser vazio");
    }

    public void setDateLaunch(Calendar dateLaunch) {
        this.dateLaunch = dateLaunch;
    }



}