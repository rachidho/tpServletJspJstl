<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css" href="css/styles.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="titre">Panier avec JSTL</div>
	<br>
	<br>
	
	<c:if test="${empty catalogue.listProduit}">
		<div class='produit'>Aucun produit dans le panier</div>
	</c:if>
	<c:forEach var="produit" items="${catalogue.listProduit}">

		<div class="produit">
			<table>
				<tr>
					<td rowspan="2"><c:if test="${!empty produit.value.image}">
							<img src='<c:out value="${produit.value.image}"></c:out>' />
						</c:if></td>
					<td><a class="nom"
						href="/tpServletJspJstl/AfficheProduit?id=<c:out value="${produit.value.id}"></c:out>">
							<c:out value="${produit.value.nom}"></c:out> </a></td>
				</tr>
				<tr>
					<td class="prix">${produit.value.prix} &nbsp;&euro;</td>
				</tr>
				<tr>
					<td colspan="2" class="desc"><c:if
							test="${!empty produit.value.description}">
							<c:out value="${produit.value.description}"></c:out>
						</c:if>
					</td>
				</tr>
			</table>
		</div>

	</c:forEach>

</body>
</html>