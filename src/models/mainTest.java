package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.dao.DatabaseConnection;
import models.entities.Evaluator;
import models.services.EvaluatorBO;

public class mainTest {
    public static void main (String args[]) {
        Evaluator evaluator = new Evaluator();
        evaluator.setCPF("12312312312");
        evaluator.setNome("Davi");
        EvaluatorBO bo = new EvaluatorBO();
        System.out.println(bo.adicionar(evaluator));
        List<Evaluator> lista = bo.listar();
    }

    /*    
        DatabaseConnection con = new DatabaseConnection(); 
        
        Connection c = con.getConnection(); 
*/
}
