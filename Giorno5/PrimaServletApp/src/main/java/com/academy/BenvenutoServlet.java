package com.academy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BenvenutoServlet
 */
//@WebServlet("/BenvenutoServlet")
public class BenvenutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int contatore = 0;
	
    public BenvenutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
        // Questo appare solo la PRIMA volta che qualcuno visita la pagina
        System.out.println(">>> LOG: Metodo init() chiamato! La Servlet è nata.");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 1. Incrementiamo il contatore (punto precedente)
        contatore++;

        // 2. Recuperiamo il parametro "nome" dalla URL
        String nomeInserito = request.getParameter("nome");
        String messaggioSaluto;

        // 3. Logica di controllo: se il parametro manca o è vuoto
        if (nomeInserito == null || nomeInserito.trim().isEmpty()) {
            messaggioSaluto = "Ciao, ospite!";
        } else {
            messaggioSaluto = "Ciao, " + nomeInserito + "!";
        }

        // 4. Prepariamo la risposta HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        // Mostriamo il saluto dinamico
        out.println("<h1>" + messaggioSaluto + "</h1>");
        // Mostriamo il contatore delle visite
        out.println("<p>Questa pagina è stata visualizzata <b>" + contatore + "</b> volte.</p>");
        out.println("</body></html>");
    }

	@Override
	public void destroy() {
	    System.out.println(">>> LOG: Metodo destroy() chiamato! La Servlet è stata rimossa.");
	}  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
