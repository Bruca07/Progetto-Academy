package com.academy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * SCOPE: SESSION (HttpSession)
 * * Quando si usa: Per dati privati di un singolo utente che devono persistere 
 * mentre l'utente naviga tra le diverse pagine del sito.
 * * Esempio Reale: Il CARRELLO DELLA SPESA in un e-commerce. Il server deve 
 * ricordare i prodotti scelti dall'utente specifico finché non conclude l'acquisto, 
 * anche se cambia pagina o aggiorna il browser.
 */
@WebServlet("/ContatoreUtenteServlet")
public class ContatoreUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContatoreUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Otteniamo la sessione dell'utente (se non esiste, viene creata)
        HttpSession session = request.getSession();

        // 2. Cerchiamo il contatore specifico per questo utente
        Integer contatoreUtente = (Integer) session.getAttribute("visitePersonali");

        if (contatoreUtente == null) {
            contatoreUtente = 1; // Prima volta per questo utente
        } else {
            contatoreUtente++; // Ritorno dell'utente
        }

        // 3. Salviamo il nuovo valore nella sessione
        session.setAttribute("visitePersonali", contatoreUtente);

        // 4. Risposta HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Scope SESSION</h1>");
        out.println("<h3>Hai visitato questa pagina <b>" + contatoreUtente + "</b> volte.</h3>");
        out.println("<p><small>Queste visite sono solo tue. Se apri un altro browser, ripartirai da 1.</small></p>");
        out.println("<a href='pagina'>Vai al contatore globale (Application)</a>");
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
