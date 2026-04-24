<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Risultato Echo</title>
</head>
<body>
    <h1>Scope REQUEST</h1>
    <p>La Servlet ha ricevuto questo testo e lo ha passato alla JSP:</p>
    
    <h2 style="color: blue;">
        <%-- Recuperiamo l'attributo che la Servlet ha messo nella request --%>
        <%= request.getAttribute("messaggioPerLaJSP") %>
    </h2>

    <hr>
    <p><small>Nota: Se ricarichi la pagina senza il parametro nell'URL, lo scope si azzera.</small></p>
    <a href="index.html">Torna alla Home</a>
</body>
</html>