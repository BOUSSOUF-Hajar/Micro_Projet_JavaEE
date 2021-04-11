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
				
			if(email!=null & mdp!=null) {
				OuvreBase();
				try {
				ResultSet r=stmt.executeQuery("SELECT Nom,Prenom FROM client WHERE Email='"+email+"' and MotPasse='"+mdp+"'");
				
				while(r==null) {
					
					user u=new user(nom,prenom,email,mdp,addr);
					String name=u.getNom();
					String fname=u.getPrenom();
					request.setAttribute("user", u);
					
				}
				while(!r.next()) {
					stmt.executeUpdate("ISERT (INTO ");
					user u=new user(nom,prenom,email,mdp,addr);
					String name=u.getNom();
					String fname=u.getPrenom();
					request.setAttribute("user", u);
					
				}
			
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
			request.getRequestDispatcher("accueil1.jsp").forward(request, response);
			
			}
	protected void OuvreBase() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
			connection = DriverManager.getConnection("jdbc:mysql://localhost/"+"microproj_mvc"+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","SOUAD1999");
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
