package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.entities.Admin;
import models.entities.Evaluator;

public class EvaluatorDao extends BaseDao<Evaluator> {
	Connection connection;
/*	
	public EvaluatorDao(Connection connection) throws SQLException {
        this.connection = connection;
    }
*/	public EvaluatorDao() {
    try {
        this.connection = new DatabaseConnection().getConnection();;
    } catch (Exception e) {
        e.printStackTrace();
    }
}
	public Evaluator inserir (Evaluator evaluator) {
		String sql = "INSERT INTO tb_evaluators (name,taxId,address_id) VALUES (?,?,?);";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, evaluator.getNome() );
			pst.setString(2, evaluator.getCPF());
			pst.setInt(3, evaluator.getAdress().getId());
			pst.execute();	
			
			return evaluator;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}				
	}
	
	public boolean deletar(Evaluator evaluator) {
		String sql = "DELETE FROM tb_evaluators WHERE taxId=?;";
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
	
	public boolean alterar(Evaluator evaluator) {
		String sql = "UPDATE tb_evaluators SET name=?,taxId=?,address_id=? WHERE taxId=? ";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, evaluator.getNome() );
			pst.setString(2, evaluator.getCPF());
			pst.setInt(3, evaluator.getAdress().getId());
			pst.executeUpdate();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		
	}
	
	public Evaluator findById(Evaluator evaluator) {
		String sql = "SELECT * FROM tb_evaluators WHERE taxId=? ;";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Evaluator a = new Evaluator();
				a.setNome(rs.getString("nome"));
				a.setCPF(rs.getString("CPF"));
				return a;
			}
			else return null;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}

	public ResultSet findAll() {
		String sql = "SELECT * FROM tb_evaluators;";
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