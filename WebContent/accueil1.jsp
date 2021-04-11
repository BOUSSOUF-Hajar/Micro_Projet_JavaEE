<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title></title>
	</head>
	<body>
<%@page import="GI2.JavaEE.MicroProject_MVC.model.user" %>
<%
user user =(user) request.getAttribute("user");
String session_userName = (String)session.getAttribute("userName");
String session_userFName = (String)session.getAttribute("userFName");
if(user==null )
{
 %>
	

     	<h3>Bienvenue chez SEBO - Veuillez-vous identifier ou vous inscrire </h3>
    <!-- 
    
    <a href="fromAccueil?ID=ident">Déjà client : identifiez-vous </a><br />
    <a href="fromAccueil?ID=inscr">Nouveau client : inscrivez-vous </a>
    
    --> 
     <a href="identifier">Déjà client : identifiez-vous </a><br /> <br/>
     <a href="inscrire">Nouveau client : inscrivez-vous </a>
    

<%} else { 
 %>
 <h3>Bonjour Mr/Mme <%=user.getNom() %> <%=user.getPrenom()%> </h3>
 <br/>
 <a href="catalogue">Consulter le catalogue </a>
 <br/>
 <br/>
 <a href="">Suivre mes commandes</a>
 <br>
 <br/>
 <a href="">Visualiser mon panier</a>
 <br/>
 <br/>
 <%} %>
 </body>
 </html>
 
 
 
