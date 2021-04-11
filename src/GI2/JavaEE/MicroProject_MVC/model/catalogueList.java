package GI2.JavaEE.MicroProject_MVC.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class catalogueList {
	
	public List<article> list() throws SQLException {
        List<article> listgenre = new ArrayList<>();
         
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/"+"microproj_mvc"+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","hajarbsf")
    			) {
            String sql = "SELECT * FROM article ORDER BY categorie";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) {
                
                String reference = result.getString("categorie");
                article genre = new article(reference);
                     
                listgenre.add(genre);
            }          
             
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }      
        
         
        return listgenre;
    }
}


