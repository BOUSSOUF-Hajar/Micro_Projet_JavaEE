package GI2.JavaEE.MicroProject_MVC.controller;

import java.io.IOException;
import java.sql.SQLException;

import GI2.JavaEE.MicroProject_MVC.model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/listGenreServlet")
public class listGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public listGenreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		listgenre(request,response);
		 	
	    
	}
	private void listgenre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		catalogueList genre =new catalogueList() ;	     
	    try {
	    	List<article> listgenre =genre.list();
	    	System.out.println(listgenre);
	    	request.setAttribute("listgenre", listgenre);
	    	request.getRequestDispatcher("WebForm1.jsp").forward(request,response);
	    	
	    	
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    	throw new ServletException(e);
	    }	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//gett id 
		String reference =request.getParameter("genre");
		request.setAttribute("Selectreference", reference);
		listgenre(request,response);
	}

}
