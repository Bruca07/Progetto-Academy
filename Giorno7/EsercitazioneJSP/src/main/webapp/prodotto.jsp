<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Importiamo la classe per permettere alla JSP di trovarla --%>
<%@ page import="com.academy.Prodotto" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dettaglio Prodotto</title>
</head>
<body>

    <jsp:include page="header.jsp" />

    <h2>Informazioni Prodotto (JavaBean)</h2>

    <%-- 1. Creiamo l'istanza del Bean (equivale a: Prodotto mioP = new Prodotto()) --%>
    <jsp:useBean id="mioP" class="com.academy.Prodotto" scope="page" />

    <%-- 2. Impostiamo le proprietà (equivale a: mioP.setNome("Laptop") ecc.) --%>
    <jsp:setProperty name="mioP" property="nome" value="Laptop" />
    <jsp:setProperty name="mioP" property="prezzo" value="999.99" />
    <jsp:setProperty name="mioP" property="disponibile" value="true" />

    <%-- 3. Visualizziamo i valori (equivale a: mioP.getNome()) --%>
    <div style="background-color: #e9ecef; padding: 20px; border-radius: 5px; border-left: 5px solid #007bff;">
        <p>Prodotto: <strong><jsp:getProperty name="mioP" property="nome" /></strong></p>
        <p>Prezzo di listino: <strong><jsp:getProperty name="mioP" property="prezzo" /> &euro;</strong></p>
        <p>Disponibilità: <strong><jsp:getProperty name="mioP" property="disponibile" /></strong></p>
    </div>

    <jsp:include page="footer.jsp" />

</body>
</html>