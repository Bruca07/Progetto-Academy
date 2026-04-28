
<%-- Pagina di test per la JSP Action 'forward': reindirizza immediatamente il flusso
 della richiesta verso la pagina di benvenuto --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Redirect</title>
</head>
<body>

    <jsp:forward page="benvenuto.jsp" />
    
</body>
</html>