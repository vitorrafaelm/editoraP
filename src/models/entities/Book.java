package models.entities;

import java.util.Calendar;

import controllers.dto.BookDTO;

public class Book {
    
    private int id;
    private Author author;
    private Evaluator evaluator; 
    private String title;
    private String description;
    private String gender;
    private String dateLaunch;
    private String status_register; //aprovado, em analise, nao aprovado

    

    //getters
    public String getTitle() {
        return title;
    }
    
    public Evaluator getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getGender() {
        return gender;
    }

    public String getDateLaunch() {
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

    public void setDateLaunch(String dateLaunch) {
        this.dateLaunch = dateLaunch;
    }

    public static Book converter(BookDTO dto) {
		Book book = new Book();
		book.setTitle(dto.getTitle());
		book.setDescription(dto.getDescription());
		book.setGender(dto.getGender());
        book.setDateLaunch(dto.getDateLaunch());
        book.setId(dto.getId());
        book.setStatus_register(dto.getStatus_register());
        book.setAuthor(dto.getAuthor());
        book.setEvaluator(dto.getEvaluator());
        
		return book;
	}


}