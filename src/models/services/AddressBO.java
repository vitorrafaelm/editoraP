package models.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllers.dto.AddressDTO;
import models.dao.AddressDao;
import models.entities.Address;
import models.dao.BaseInterDAO;

public class AddressBO {
	BaseInterDAO<Address> dao = new AddressDao();
		
	public Address adicionar(AddressDTO dto) throws SQLException {
		Address address = Address.converter(dto);
		
		return dao.inserir(address);
	}
	
	public List<Address> listar(){
		List<Address> addresses = new ArrayList<Address>();
		ResultSet rs = dao.findAll();
		try {	
			while(rs.next()) {
				Address address = new Address();
				address.setStreet(rs.getString("street"));
				address.setNeightboohood(rs.getString("neightboohood"));
				address.setNumber(rs.getString("number"));
				address.setZipcode(rs.getString("zipcode"));
				address.setId(rs.getInt("id"));
				addresses.add(address);
			}
			return addresses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean atualizar (Address address) {
		ResultSet rs = dao.findBySpecifiedField(address, "cpf");
		try {
			if(rs!=null && rs.next() ) {
				if(dao.alterar(address) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	public boolean apagar (Address address) {
		ResultSet rs = dao.findBySpecifiedField(address, "id");
		try {
			if(rs!=null && rs.next() ) {
				if(dao.deletar(address) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
}
