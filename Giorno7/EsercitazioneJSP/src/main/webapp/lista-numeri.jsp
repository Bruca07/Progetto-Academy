
<%-- Pagina che utilizza un ciclo for Java (scriptlet) per generare 
automaticamente una lista HTML di numeri da 1 a 10 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista Numeri</title>
</head>
<body>

    
    <%@ include file="header.jsp" %>

    <ul>
        <% for (int i = 1; i <= 10; i++) { %>
            <li>Numero <%= i %></li>
        <% } %>
    </ul>

</body>
</html>