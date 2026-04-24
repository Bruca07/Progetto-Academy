package com.academy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 1. Recuperiamo la sessione esistente (false = non crearne una nuova se non c'è)
        HttpSession session = request.getSession(false);
        
        // 2. Controlliamo se la sessione esiste e se contiene l'attributo salvato nella LoginServlet
        String username = null;
        if (session != null) {
            username = (String) session.getAttribute("utenteLoggato");
        }

        
        if (username == null) {
            // Utente non autenticato: redirect al login
            System.out.println("ACCESSO NEGATO: Tentativo di accesso alla dashboard senza login.");
            response.sendRedirect("login.html");
        } else {
            // Utente autenticato: mostra il contenuto
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Benvenuto, " + username + "!</h1>");
            response.getWriter().println("<h3>Sei nella dashboard.</h3>");
            response.getWriter().println("<p>Questa pagina è protetta e visibile solo agli utenti loggati.</p>");
            response.getWriter().println("<br><a href='logout'>Effettua il Logout</a>");
            response.getWriter().println("</body></html>");
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
