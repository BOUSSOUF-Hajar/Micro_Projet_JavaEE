<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Inscription</title>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body> 
   <h3>Inscrivez-vous :</h3>
   <form action="inscrire" method="post">
      <label>Nom :<span class="requis">*</span></label><br />
      <input type="text" name="nom"  value="${param.nom}" /><br />
      <span class="erreur">${erreurs['nom']}</span> <br />
      
      <label>Prénom :<span class="requis">*</span></label><br />
      <input type="text" name="prenom"  value="${param.prenom}"/><br />
      <span class="erreur">${erreurs['prenom']}</span> <br />
      <label>Addresse :</label><br />
      <input type="text" name="addr" value="${param.addr}" /><br />
      
      <label>Email :<span class="requis">*</span></label><br />
      <input type="text" name="email"  value="${param.email}" /><br />
      <span class="erreur">${erreurs['email']}</span> <br />
       <label>Mot de passe :<span class="requis">*</span></label><br />
       <input type="password" name="mdp" /><br />
       <span class="erreur">${erreurs['motdepasse']}</span> <br />
      
      <input type="submit" name="okBtn" value="OK" />
   </form>
</body>
</html>