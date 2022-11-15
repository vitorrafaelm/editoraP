package models.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllers.dto.AddressDTO;
import controllers.dto.EvaluatorDTO;
import models.dao.BaseInterDAO;
import models.dao.EvaluatorDao;
import models.entities.Address;
import models.entities.Evaluator;

public class EvaluatorBO {
    BaseInterDAO<Evaluator> dao = new EvaluatorDao();
       
    public boolean adicionar (EvaluatorDTO dto) {
        Evaluator evaluator = Evaluator.converter(dto);
        ResultSet rs = dao.findBySpecifiedField(evaluator, "cpf");
        try {
            if(rs==null || !(rs.next()) ) {
                if(dao.inserir(evaluator) == true)
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

    public List<EvaluatorDTO> listar(){
        List<EvaluatorDTO> evaluators = new ArrayList<EvaluatorDTO>();
        ResultSet rs = dao.findAll();
        try {
            while(rs.next()) {
                AddressDTO dtoA = new AddressDTO();
                
                dtoA.setStreet(rs.getString("Rua"));
                dtoA.setNeightboohood(rs.getString("Bairro"));
                dtoA.setNumber(rs.getString("número"));
                dtoA.setCity(rs.getString("Cidade"));
                dtoA.setZipcode(rs.getString("CEP"));
                AddressBO temp = new AddressBO();
               Address address = temp.adicionar(dtoA);
                
                EvaluatorDTO evaluator = new EvaluatorDTO();
                evaluator.setCpf(rs.getString("cpf"));
                evaluator.setAddress(address);
                evaluator.setName(rs.getString("nome"));
                //evaluator.setId(rs.getInt("id"));
                
                evaluators.add(evaluator);
            }
            return evaluators;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public boolean atualizar (Evaluator evaluator) {
        
        ResultSet rs = dao.findBySpecifiedField(evaluator, "cpf");
        try {
            if(rs!=null && rs.next() ) {
                if(dao.alterar(evaluator) == true)
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

    public boolean apagar (Evaluator evaluator) {
        ResultSet rs = dao.findBySpecifiedField(evaluator, "cpf");
        try {
            if(rs!=null && rs.next() ) {
                if(dao.deletar(evaluator) == true)
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
