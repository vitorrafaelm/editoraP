package models.services;

import java.sql.SQLException;

import controllers.dto.EvaluatorDTO;
import models.dao.BaseInterDAO;
import models.dao.EvaluatorDao;
import models.entities.Evaluator;

public class EvaluatorBO {
    BaseInterDAO<Evaluator> dao = new EvaluatorDao();
    
    public boolean adicionar (EvaluatorDTO dto) {
        Evaluator evaluator = Evaluator.converter(dto);
    
    try {
        return dao.inserir(evaluator);
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return null;
    }   
}
