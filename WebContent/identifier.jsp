<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Identification</title>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
   <h3>Identifiez-vous</h3>
  <form action="identifier" method="post">
      <label>Email :</label><br />
      <input type="text" name="email" value="${param.email}" /><br />
      <span class="erreur">${erreurs['email']}</span> <br />
      
       <label>Mot de passe :</label><br />
      <input type="password" name="mdp"  /><br />
      <input type="submit" name="okBtn" value="OK" />
      <br>
      <br><span class="erreur">${erreurs['user']}</span> <br />
  </form>

</body>
</html>