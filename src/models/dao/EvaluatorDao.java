package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.entities.Address;
import models.entities.Evaluator;

public class EvaluatorDao extends BaseDao<Evaluator> {
	Connection connection;

	public EvaluatorDao() {
        try {
            this.connection = new DatabaseConnection().getConnection();;
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public ResultSet findAll() {
        String sql = "SELECT * FROM tb_evaluator ta LEFT JOIN tb_address ta2 ON ta2.id = ta.address_id;";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
            return null;
        }
	}
	public Evaluator inserir (Evaluator evaluator) {
		String sql = "INSERT INTO tb_evaluator (name, email, password,taxId,address_id) VALUES (?,?,?,?,?);";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, evaluator.getNome());
			pst.setString(2, evaluator.getEmail());
			pst.setString(3, evaluator.getPassword());
			pst.setString(4, evaluator.getCPF());
			pst.setInt(5, evaluator.getAdress().getId());
			pst.execute();	
			
			return evaluator;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}				
	}
	
	public boolean deletar(Evaluator evaluator) {
		String sql = "DELETE FROM tb_evaluator WHERE taxId=?;";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, evaluator.getCPF());
			pst.execute();
			
			return true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean alterar(Evaluator evaluator, String cpf) {
		String sql = "UPDATE tb_evaluator SET name=?,taxId=?, email=?, password=? WHERE taxId=?";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, evaluator.getNome());
			pst.setString(2, evaluator.getCPF());
			pst.setString(3, evaluator.getEmail() );
            pst.setString(4, evaluator.getPassword());
            pst.setString(5, cpf);
			pst.executeUpdate();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		
	}
	
	public Evaluator findById(Evaluator evaluator) {
		String sql = "SELECT * FROM tb_evaluator as ath LEFT JOIN tb_address as tba on tba.id = ath.address_id WHERE ath.taxId=? ;";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, evaluator.getCPF());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Evaluator a = new Evaluator();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("name"));
				a.setCPF(rs.getString("taxId"));
				a.setEmail(rs.getString("email"));
				a.setPassword(rs.getString("password"));
				
				Address address = new Address();
                
                address.setId(rs.getInt("address_id"));
                address.setCity(rs.getString("city"));
                address.setNeightboohood(rs.getString("neightboohood"));
                address.setNumber(rs.getString("number_house"));
                address.setStreet(rs.getString("street"));
                address.setZipcode(rs.getString("zipcode"));
                
                a.setAddress(address);
				return a;
			}
			else return null;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}

	
	public ResultSet findBySpecifiedField(Evaluator evaluator, String field) {
		// TODO Auto-generated method stub
		return null;
	}


	public Evaluator findBySpecifiedFieldAdmin(Evaluator e, String field) {
        String sql = "SELECT * FROM tb_evaluator WHERE " + field +"=? ;";
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
                Evaluator evaluator = new Evaluator();
                evaluator.setEmail(rs.getString("email"));
                evaluator.setPassword(rs.getString("password"));
                evaluator.setNome(rs.getString("name"));
                evaluator.setId(rs.getInt("id"));
                return evaluator;
            }
            
            return null;
        
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
            return null;
        }
    }
	
	
}
