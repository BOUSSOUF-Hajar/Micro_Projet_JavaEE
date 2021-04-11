package GI2.JavaEE.MicroProject_MVC.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletInscription() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("inscrire.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resultat ;
		 
		Map<String,String > erreurs= new HashMap<String, String>();
		String email = request.getParameter("email");
		String motdepasse = request.getParameter("mdp");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		
		 try {
	            validationEmail(email);
	            
	        } catch (Exception e) {
	                /* Gérer les erreurs de validation ici. */
	        	  erreurs.put("email" , e.getMessage() ) ;
	        }		 
		 try {
	            validationmdp( motdepasse );
	            
	        } catch (Exception e) {
	            /* Gérer les erreurs de validation ici. */
	        	  erreurs.put( "motdepasse", e.getMessage() );
	        }
		 try {
	            validationom( nom );
	            
	        } catch (Exception e) {
	            /* Gérer les erreurs de validation ici. */
	        	  erreurs.put( "nom", e.getMessage() );
	        }
		 try {
	            validatioprenom( prenom );
	            
	        } catch (Exception e) {
	            /* Gérer les erreurs de validation ici. */
	        	 erreurs.put("prenom", e.getMessage() );
	        }
		
		 if ( !erreurs.isEmpty() ) {
			 
	            resultat = "Échec de l'inscription.";
	        
		 request.setAttribute( "erreurs", erreurs );
	     request.setAttribute( "resultat", resultat );
	     this.getServletContext().getRequestDispatcher("/inscrire.jsp").forward( request, response );
		 }
		 else {
			 this.getServletContext().getRequestDispatcher("Servlet1").forward( request, response );
			 
		 }
		//doGet(request, response);
	    
	     
	}
	
	void validationEmail( String email ) throws Exception {
	    if ( email != null && email.trim().length() != 0 ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail valide." );
	    }
	}
	void validationmdp ( String motdepasse ) throws Exception {
	    if ( motdepasse != null && motdepasse.trim().length() != 0 ) {
	        
	    } else {
	        throw new Exception( "Merci de saisir un mot de passe." );
	    }
}
	void validationom ( String nom ) throws Exception {
	    if ( nom != null && nom.trim().length() != 0 ) {
	    	System.out.println("");
	        
	    } else {
	        throw new Exception( "Merci de saisir un nom." );
	    }
}
	void validatioprenom ( String prenom ) throws Exception {
	    if (prenom != null && prenom.trim().length() != 0 ) {
	        
	    } else {
	        throw new Exception( "Merci de saisir un prenom." );
	    }
}
	
	}
