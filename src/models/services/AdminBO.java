package models.services;

import java.sql.SQLException;

import controllers.dto.UserDTO;
import exceptions.AuthError;
import exceptions.AuthenticationException;
import models.dao.AdminDao;
import models.entities.Admin;

public class AdminBO {
    private AdminDao AdminDAO = new AdminDao();
    
    
    public Admin authenticate(UserDTO data) throws AuthenticationException, SQLException {
        Admin admin = Admin.converter(data);
        
        Admin user = this.AdminDAO.findBySpecifiedFieldAdmin(admin, "email");

        if (user == null)
            throw new AuthenticationException(AuthError.NOT_FOUND);
        if (!data.getPassword().equals(user.getPassword()))
            throw new AuthenticationException(AuthError.WRONG_PASSWORD);

        return user;
    }
}   
