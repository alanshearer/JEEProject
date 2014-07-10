<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*, model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JPA Object book web application tutorial</title>
</head>
<body>
<form action="jpaobjectservlet" method="post">
Name: <input type="text" name="name" />
<input type="submit" name="AddButton" value="Add" />
</form>
<br/>
<form action="jpaobjectservlet" method="get">
Search string: <input type="text" name="searchString" />
<input type="submit" name="SearchButton" value="Search" />
</form>


<hr>
<table><% @SuppressWarnings("unchecked")
List<JPAObject> jpaobjects = (List<JPAObject>)request.getAttribute("jpaobject");
if (jpaobjects != null){
	for (JPAObject jpaobject : jpaobjects){ %>
		<tr><td> <%= jpaobject.toString() %></td>
		<td>
		<form action="jpaobjectservlet" method="post">
		<input type="hidden" name="jpaObjectToDelete" value="<%= jpaobject.getId() %>" />
		<input type="submit" name="DeleteButton" value="Delete" />
		</form>
		</td>
		</tr>
	<% }

}

%>
</table>
</hr>

        <iframe src="http://www.objectdb.com/pw.html?jee-eclipse"
            frameborder="0" scrolling="no" width="100%" height="30"> </iframe>
</body>
</html>