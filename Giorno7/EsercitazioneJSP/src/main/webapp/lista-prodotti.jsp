<%-- Pagina che visualizza la lista prodotti usando JSTL invece delle scriptlet Java --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Taglib Core per i cicli e le condizioni --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- Taglib Format per formattare i numeri e la valuta --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Catalogo Prodotti</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px; }
        table { width: 85%; margin: 20px auto; border-collapse: collapse; background: white; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #28a745; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .stato-ok { color: green; font-weight: bold; }
        .stato-ko { color: red; font-weight: bold; }
        .fascia-economico { color: blue; font-style: italic; }
        .fascia-medio { color: orange; font-weight: bold; }
        .fascia-costoso { color: purple; font-weight: bold; text-transform: uppercase; }
        
        /* Stile per il riepilogo finale */
        .riepilogo { 
            width: 85%; 
            margin: 20px auto; 
            padding: 15px; 
            background-color: #fff; 
            border-left: 5px solid #28a745; 
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            text-align: center;
            font-size: 1.1em;
        }
    </style>
</head>
<body>

    <jsp:include page="header.jsp" />

    <h1 style="text-align: center; color: #333;">Catalogo Prodotti Online</h1>

    <table>
        <thead>
            <tr>
                <th>Nome Prodotto</th>
                <th>Prezzo</th>
                <th>Disponibilità</th>
                <th>Fascia Prezzo</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${elencoProdotti}" var="p">
                <tr>
                    <td><c:out value="${p.nome}" /></td>
                    <td><c:out value="${p.prezzo}" /> &euro;</td>
                    
                    <td>
                        <c:if test="${p.disponibile}">
                            <span class="stato-ok">Disponibile</span>
                        </c:if>
                        <c:if test="${!p.disponibile}">
                            <span class="stato-ko">Non disponibile</span>
                        </c:if>
                    </td>

                    <td>
                        <c:choose>
                            <c:when test="${p.prezzo < 20}">
                                <span class="fascia-economico">Economico</span>
                            </c:when>
                            <c:when test="${p.prezzo >= 20 && p.prezzo <= 100}">
                                <span class="fascia-medio">Medio</span>
                            </c:when>
                            <c:otherwise>
                                <span class="fascia-costoso">Costoso</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <%--  Mostra Totale e Prezzo Medio --%>
    <div class="riepilogo">
        Totale prodotti: <strong>${numeroProdotti}</strong> | 
        Prezzo totale: <strong><fmt:formatNumber value="${totalePrezzi}" type="currency" currencySymbol="&euro;" /></strong> | 
        Prezzo medio: <strong><fmt:formatNumber value="${prezzoMedio}" maxFractionDigits="2" minFractionDigits="2" /> &euro;</strong>
    </div>

    <jsp:include page="footer.jsp" />

</body>
</html>