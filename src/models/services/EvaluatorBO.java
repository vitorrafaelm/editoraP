package models.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllers.dto.EvaluatorDTO;
import controllers.dto.UserDTO;
import exceptions.AuthError;
import exceptions.AuthenticationException;
import models.dao.BaseInterDAO;
import models.dao.EvaluatorDao;
import models.entities.Address;
import models.entities.Evaluator;

public class EvaluatorBO {
   BaseInterDAO<Evaluator> dao = new EvaluatorDao();
   
   public Evaluator authenticate(UserDTO data) throws AuthenticationException, SQLException {
       Evaluator evaluator = Evaluator.converter(data);
       
       Evaluator user = this.dao.findBySpecifiedFieldAdmin(evaluator, "email");

       if (user == null)
           throw new AuthenticationException(AuthError.NOT_FOUND);
       if (!data.getPassword().equals(user.getPassword()))
           throw new AuthenticationException(AuthError.WRONG_PASSWORD);
       
       return user;
   }
       
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

    public boolean atualizar (EvaluatorDTO evaluator, String cpf) {
        Evaluator eva = Evaluator.converter(evaluator);
        try {
            return dao.alterar(eva, cpf);
        } catch (Exception e) {
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
    
    
    public Evaluator findEvaluatorUnique(Evaluator evaluator) {
        try {
            return dao.findById(evaluator);
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
