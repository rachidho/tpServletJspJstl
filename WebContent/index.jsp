<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="index.jsp?var=fr"> fr </a> |
	<a href="index.jsp?var=en"> en </a>

	<%
		String var = request.getParameter("var");
		if (null != var) {
			if (var.equals("fr")) {
	%>
	<fmt:setLocale value="fr" scope="session" />
	<%
		}

			if (var.equals("en")) {
	%>
	<fmt:setLocale value="en" scope="session" />
	<%
		}
		}
	%>
	<fmt:setBundle basename="Messages" />

	<h1>
		<fmt:message key="message.bienvenu"></fmt:message>
	</h1>

	<a href="/tpServletJspJstl/AfficheCatalogueJSP"><fmt:message
			key="message.affiche.catalogue.jsp"></fmt:message> </a>
	<br />
	<a href="/tpServletJspJstl/AfficheCatalogueJSTL"><fmt:message
			key="message.affiche.catalogue.jstl"></fmt:message> </a>
	<br />

</body>
</html>