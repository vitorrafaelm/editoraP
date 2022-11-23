package controllers.dto;

import java.util.Calendar;
import models.entities.Author;
import models.entities.Evaluator;


public class BookDTO {
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    private Author author;
	private String title;
    private String description;
    private String gender;
    private String dateLaunch;
    private String status_register;
    private Evaluator evaluator;

	public String getTitle() {
        return title;
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

    public Evaluator getEvaluator() {
        return evaluator;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void setStatus_register(String status_register) {

        this.status_register = status_register;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateLaunch(String dateLaunch) {
        this.dateLaunch = dateLaunch;
    }

}