<%-- Pagina che riceve due parametri numerici dalla URL, esegue la somma lato server e gestisce 
eventuali errori di inserimento o parametri mancanti --%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calcolatrice JSP</title>
</head>
<body>

    <%@ include file="header.jsp" %>

    <h2> Calcolatrice</h2>

    <%
        // 1. Leggiamo i parametri dalla URL (arrivano sempre come String)
        String s1 = request.getParameter("num1");
        String s2 = request.getParameter("num2");

        // 2. Controlliamo se i parametri esistono
        if (s1 != null && s2 != null) {
            try {
                // 3. Convertiamo le stringhe in numeri interi
                int n1 = Integer.parseInt(s1);
                int n2 = Integer.parseInt(s2);
                int somma = n1 + n2;
    %>
                <%-- Se tutto è ok, mostriamo il risultato --%>
                <p style="font-size: 20px;">
                    Risultato: <strong><%= n1 %> + <%= n2 %> = <%= somma %></strong>
                </p>
    <%
            } catch (NumberFormatException e) {
    %>
                <p style="color: red;">Errore: Inserisci solo numeri validi!</p>
    <%
            }
        } else {
    %>
            <%-- Messaggio di istruzioni se mancano i parametri --%>
            <div style="background-color: #fff3cd; padding: 15px; border: 1px solid #ffeeba;">
                <p><strong>Istruzioni:</strong> Aggiungi i numeri alla fine dell'indirizzo nel browser.</p>
                <p>Esempio: <code>?num1=10&num2=5</code></p>
            </div>
    <%
        }
    %>
    		<jsp:include page="footer.jsp" />

</body>
</html>