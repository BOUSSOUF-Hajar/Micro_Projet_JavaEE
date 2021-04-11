<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WebForm1</title>
</head>
<body>

<div align="center"> 
 <h1>Catalogue</h1>
 
  <form action="catalogue" method="post">
  <label>  choisissez le genre </label>
  Select a genre:&nbsp;
  <select name="genre" >
  <c:forEach items="${listgenre}" var="category">
  <option value="${article.reference }" 
  <c:if test="${article.reference eq Selectreference }"> selected="selected" </c:if>
  >
  ${article.reference}
  
  </option>
  </c:forEach>
   </select>
   </br>
   </br>
   </form>
</div>


<sql:setDataSource var="datasource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/microproj_mvc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" user="root"  password="hajarbsf"/>
<sql:query  var="catalogue" dataSource="${datasource}">
</sql:query>
select * from article ;
<table border="1">
<tr>
<th> Reference</th>
<th>titre</th>
<th>auteur</th>
<th>photo</th>
<th>prix</th>
<th>   </th>

</tr>
<c:forEach var="row" items='${catalogue.rows }'>
<tr>
<td><c:out value='${row.CodeArticle}' /></td>
<td><c:out value='${row.Designation}' /></td>

<td><c:out value='${row.photo}' /></td>
<td><c:out value='${row.prix}' /></td>
<td> <a href="Ajouter au panier?panier=oui"></a>  </td>
 



</tr>
</c:forEach>
</table>




</body>
</html>