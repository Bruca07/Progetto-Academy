package com.academy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SCOPE: REQUEST (HttpServletRequest)
 * * Quando si usa: Per dati volatili che servono solo a generare la risposta 
 * per la richiesta corrente. Una volta visualizzata la pagina, il dato sparisce.
 * * Esempio Reale: Un MESSAGGIO DI ERRORE (es. "Password errata"). Se l'utente 
 * sbaglia il login, la Servlet passa il messaggio alla pagina JSP. Se l'utente 
 * ricarica la pagina o va altrove, il messaggio di errore non deve più apparire.
 */
@WebServlet("/EchoServlet")
public class EchoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EchoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Recuperiamo il parametro "testo" dalla URL
        String messaggioInviato = request.getParameter("testo");

        if (messaggioInviato == null || messaggioInviato.isEmpty()) {
            messaggioInviato = "Nessun testo fornito.";
        }

        // 2. Salviamo il dato nello scope REQUEST
        // Questo dato vivrà solo fino alla fine di questa specifica chiamata
        request.setAttribute("messaggioPerLaJSP", messaggioInviato);

        // 3. Facciamo il FORWARD alla JSP
        // Passiamo la "palla" alla JSP per mostrare il risultato
        RequestDispatcher dispatcher = request.getRequestDispatcher("visualizza_echo.jsp");
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
