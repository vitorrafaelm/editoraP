package models.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import api.dto.EvaluatorDTO;
import models.dao.BaseInterDAO;
import models.dao.EvaluatorDao;
import models.entities.Address;
import models.entities.Evaluator;

public class EvaluatorBO {
    BaseInterDAO<Evaluator> dao = new EvaluatorDao();
       
   public Evaluator adicionar(EvaluatorDTO dto) throws SQLException {
        Evaluator evaluator = Evaluator.converter(dto);
        return dao.inserir(evaluator);
    }
    
    public List<EvaluatorDTO> listar(){
        List<EvaluatorDTO> evaluators = new ArrayList<EvaluatorDTO>();
        ResultSet rs = dao.findAll();
        try {
            while(rs.next()) {
                Address address = new Address();
                
                address.setStreet(rs.getString("street"));
                address.setNeightboohood(rs.getString("neightboohood"));
                address.setNumber(rs.getString("number_house"));
                address.setCity(rs.getString("city"));
                address.setZipcode(rs.getString("zipcode"));
                                
                EvaluatorDTO evaluator = new EvaluatorDTO();
                evaluator.setCpf(rs.getString("taxId"));
                evaluator.setAddress(address);
                evaluator.setName(rs.getString("name"));
                evaluator.setId(rs.getInt("id"));
                
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

    public boolean deletar(Evaluator evaluator) {
        try {
            return dao.deletar(evaluator);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
/* public boolean adicionar (EvaluatorDTO dto) {
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
}*/

/*    public boolean apagar (Evaluator evaluator) {
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
}*/
