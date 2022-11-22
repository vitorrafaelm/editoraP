package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.dto.UserDTO;
import exceptions.AuthError;
import exceptions.AuthenticationException;
import models.entities.Admin;

public class AdminDao extends BaseDao<Admin> {
    Connection connection;
    
    public AdminDao() {
        try {
            this.connection = new DatabaseConnection().getConnection();;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Admin findBySpecifiedFieldAdmin(Admin e, String field) {
        String sql = "SELECT * FROM tb_admin WHERE " + field +"=? ;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            switch (field) {
            case "email":
                pst.setString(1, e.getEmail());
                break;
            default: 
                pst.setInt(1, e.getId());
            }
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()) {
                Admin admin = new Admin();
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                admin.setName(rs.getString("name"));
                admin.setId(rs.getInt("id"));
                return admin;
            }
            
            return null;
        
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
            return null;
        }
    }
}
