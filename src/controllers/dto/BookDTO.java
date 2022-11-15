package controllers.dto;

import java.util.Calendar;
import models.entities.Book;
import models.entities.Author;

public class BookDTO {
    private Author author;
	private String title;
    private String description;
    private String gender;
    private Calendar dateLaunch;
    private String status_register;
	private 

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

    public void setDateLaunch(Calendar dateLaunch) {
        this.dateLaunch = dateLaunch;
    }

}