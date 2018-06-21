<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<h2 align="center">Items Records</h2>

		<table align="center" border="2">
		
		<tr>
			<th>ItemId</th>
			<th>ItemName</th>
			<th>ItemPrice</th>
			<th>ItemDescription</th>				
		</tr>
		
			<c:forEach items="${itemsList}" var="items">
				
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td>${item.Description}</td>
				</tr>		
				
			</c:forEach>
			
		
		
		</table>	

</body>
</html>