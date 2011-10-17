<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="fr.shopping.bean.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css" href="css/styles.css">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
	<div class="titre">Catalogue</div>
	<br>
	<br>
	<%
		Catalogue catalogue = Catalogue.getInstance();
		for (Map.Entry<String, Produit> entry : catalogue.getListProduit()
				.entrySet()) {
	%>
	<div class="produit">
		<table>
			<tr>
				<td rowspan="2"> <% if(null != entry.getValue().getImage()){ %><img src="<%= entry.getValue().getImage() %>" /><%} %></td>
				<td><a class="nom"
					href="/tpServletJspJstl/AfficheProduit?id=<%=entry.getKey()%>"> <%=entry.getValue().getNom()%>
				</a></td>
			</tr>
			<tr>
				<td class="prix"><%=entry.getValue().getPrix() %> &nbsp;&euro;</td>
			</tr>
			<tr>
				<td colspan="2" class="desc"><% if(null != entry.getValue().getDescription()){ %><%=entry.getValue().getDescription() %><%} %></td>
			</tr>
		</table>
	</div>
	<%
		}
	%>
</body>
</html>