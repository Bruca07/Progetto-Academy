
<%-- Pagina di atterraggio che mostra un messaggio di benvenuto e 
genera dinamicamente la data e l'ora corrente tramite Java --%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Benvenuto</title>
</head>
<body>
<h1>BENVENUTO!</h1>
<%
        
        // Recuperiamo la data e l'ora correnti
        LocalDateTime oraAttuale = LocalDateTime.now();
        
        // Definiamo un formato leggibile per l'utente
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataVisualizzata = oraAttuale.format(formato);
    %>

    <p>
        <%-- EXPRESSION: Mostriamo il risultato calcolato nello scriptlet --%>
        Oggi è il giorno: <strong><%= dataVisualizzata %></strong>
    </p>
</body>
</html>