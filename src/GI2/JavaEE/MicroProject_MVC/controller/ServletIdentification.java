package GI2.JavaEE.MicroProject_MVC.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletIdentification extends HttpServlet {
	private Connection connection=null;
	private Statement stmt=null;
	private static final long serialVersionUID = 1L;
       
    
    public ServletIdentification() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		request.getRequestDispatcher("identifier.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resultat ;
		 
		Map<String,String > erreurs= new HashMap<String, String>();
		String email = request.getParameter("email");
		String motdepasse = request.getParameter("mdp");
		
		
		
		 try {
	            validationEmail(email);
	            
	        } catch (Exception e) {
	                /* Gérer les erreurs de validation ici. */
	        	  erreurs.put("email" , e.getMessage() ) ;
	        }		 
		 try {
	            validationUser(email,motdepasse );
	            
	        } catch (Exception e) {
	            /* Gérer les erreurs de validation ici. */
	        	  erreurs.put( "user", e.getMessage() );
	        }
		
		 if ( !erreurs.isEmpty() ) { 
		 request.setAttribute( "erreurs", erreurs );
	     this.getServletContext().getRequestDispatcher("/identifier.jsp").forward( request, response );
		 }
		 else {
			 this.getServletContext().getRequestDispatcher("/Servlet1").forward( request, response );
			 
		 }
	}
	void validationEmail( String email ) throws Exception {
	    if ( email != null && email.trim().length() != 0 ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}
	void validationUser(String email,String motdepasse) throws Exception{
		OuvreBase();
		try {
		ResultSet r=stmt.executeQuery("SELECT Nom,Prenom FROM client WHERE email='"+email+"' and mdp='"+motdepasse+"'");
		if(r.next()) {
			
		}
		else {
			throw new Exception( "vous n'étes pas inscrit !!" );
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	protected void OuvreBase() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
			connection = DriverManager.getConnection("jdbc:mysql://localhost/"+"microproj_mvc"+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","hajarbsf");
			connection.setAutoCommit(true);
			stmt = connection.createStatement();
		}
		catch (Exception E) { 
			log(" --------probeme " + E.getClass().getName() );
			E.printStackTrace();
		} 
	}
}
