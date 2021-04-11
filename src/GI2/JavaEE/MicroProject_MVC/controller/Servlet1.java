package GI2.JavaEE.MicroProject_MVC.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GI2.JavaEE.MicroProject_MVC.model.user;



public class Servlet1 extends HttpServlet {
	private Connection connection=null;
	private Statement stmt=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom=request.getParameter("nom");
		String mdp=request.getParameter("mdp");
		String prenom=request.getParameter("prenom");
		String email=request.getParameter("email");
		String addr=request.getParameter("addr");
		user u=null;
				
			if(email!=null & mdp!=null) {
				OuvreBase();
				try {
				ResultSet r=stmt.executeQuery("SELECT Nom,Prenom FROM client WHERE email='"+email+"' and mdp='"+mdp+"'");
				if(r.next()!=true) {
					stmt.executeUpdate("INSERT INTO client values('"+nom+"','"+prenom+"','"+email+"','"+addr+"','"+mdp+"')");
				}
				ResultSet r1=stmt.executeQuery("SELECT Nom,Prenom FROM client WHERE email='"+email+"' and mdp='"+mdp+"'");
				
					while(r1.next()) {
						nom=r1.getString(1);
						prenom=r1.getString(2);
					}
					u=new user(nom,prenom,email,addr,mdp);
					HttpSession session = request.getSession();	
					session.setAttribute("userName",nom);
					session.setAttribute("userFName",prenom);
					
				
			
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
			request.setAttribute("user", u);
			request.getRequestDispatcher("accueil1.jsp").forward(request, response);
			
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
