package com.academy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* ESEMPIO SCOPE APPLICATION:
	 * Utilizzo questo scope per un contatore globale.
	 * Esempio reale: Numero di utenti totali registrati al sito.
	 */
@WebServlet("/ContatorePaginaServlet")
public class ContatorePaginaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContatorePaginaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Recuperiamo il ServletContext (Scope APPLICATION)
        ServletContext ctx = getServletContext();

        // 2. Leggiamo il valore attuale (usiamo i blocchi synchronized per evitare problemi con accessi simultanei)
        synchronized (ctx) {
            Integer totale = (Integer) ctx.getAttribute("contatoreGlobale");

            if (totale == null) {
                totale = 1; // Inizializzazione se è la prima volta assoluta
            } else {
                totale++; // Incremento
            }

            // 3. Salviamo il valore aggiornato nello scope Application
            ctx.setAttribute("contatoreGlobale", totale);

            // 4. Risposta HTML
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Scope APPLICATION</h1>");
            out.println("<p>Questa pagina è stata visitata <b>" + totale + 
                        "</b> volte in totale (da tutti gli utenti).</p>");
            out.println("<p><small>Prova ad aprire questo URL da un altro browser: vedrai che il numero continua a salire!</small></p>");
            out.println("</body></html>");
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
