package com.academy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
//@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 1. Impostiamo il formato della risposta
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();

        // 2. Recuperiamo i dati tecnici richiesti
        String metodo = request.getMethod();              // Restituisce GET o POST
        String urlCompleta = request.getRequestURL().toString(); // L'indirizzo intero
        
        // 3. Stampiamo i dati nell'HTML
        out.println("<html><body>");
        out.println("<h2>Dettagli della Richiesta (InfoServlet)</h2>");
        out.println("<p><b>Metodo HTTP usato:</b> " + metodo + "</p>");
        out.println("<p><b>URL completa:</b> " + urlCompleta + "</p>");

        // 4. Ciclo per mostrare tutti i parametri ricevuti
        out.println("<h3>Elenco Parametri ricevuti:</h3>");
        out.println("<ul>");
        
        // Prendiamo tutti i nomi dei parametri (es. nome, eta, citta)
        java.util.Enumeration<String> nomiParametri = request.getParameterNames();
        
        if (!nomiParametri.hasMoreElements()) {
            out.println("<li>Nessun parametro inserito nell'URL.</li>");
        } else {
            while (nomiParametri.hasMoreElements()) {
                String nome = nomiParametri.nextElement();
                String valore = request.getParameter(nome);
                out.println("<li>" + nome + ": <b>" + valore + "</b></li>");
            }
        }
        
        out.println("</ul>");
        out.println("</body></html>");
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
