package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.entities.Evaluator;
import models.entities.Address;

public class EvaluatorDao extends BaseDao<Evaluator> {
	
	Connection connection;
	
	public EvaluatorDao(Connection connection) throws SQLException {
        this.connection = connection;
    }
	
	public boolean inserir (Evaluator evaluator) {
		String sql = "INSERT INTO tb_evaluator (id,name,cpf,address) VALUES (?,?,?,?);";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, evaluator.getId());
			pst.setString(2, evaluator.getName() );
			pst.setString(3, evaluator.getCPF());
			pst.setString(4, evaluator.getAddress());
			pst.execute();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}				
	}
	
	public boolean deletar(Evaluator evaluator) {
		String sql = "DELETE FROM tb_evaluator WHERE id=?;";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, evaluator.getId());
			pst.execute();
			
			return true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean alterar(Evaluator evaluator) {
		String sql = "UPDATE tb_evaluator SET id=?,name=?,cpf=?,address=? WHERE id=? ";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, evaluator.getId());
			pst.setString(2, evaluator.getName() );
			pst.setString(3, evaluator.getCPF());
			pst.setString(4, evaluator.getAddress());
			pst.executeUpdate();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		
	}
	
	public Evaluator findById(Evaluator evaluator) {
		String sql = "SELECT * FROM tb_evaluator WHERE id=? ;";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Evaluator a = new Evaluator();
				a.setId(rs.getString("id"));
				a.setName(rs.getString("nome"));
				a.setCPF(rs.getString("CPF"));
				a.set(rs.getString("address"));
				a.setId(evaluator.getId());
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
		String sql = "SELECT * FROM tb_evaluator;";
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
}