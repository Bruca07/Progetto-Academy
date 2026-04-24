package com.academy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RoutingServlet
 */
@WebServlet({"/azione-forward", "/azione-redirect", "/destinazione"})
public class RoutingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoutingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String path = request.getServletPath();
        
        
     // DIFFERENZA TRA FORWARD E REDIRECT 

        /* * FORWARD: 
         * - Avviene interamente sul SERVER.
         * - Il browser NON cambia URL e NON sa che la risorsa è stata spostata.
         * - È più veloce (una sola richiesta HTTP).
         * - Si usa per passare dati tra componenti (es. da Servlet a JSP) 
         * perché l'oggetto 'request' viene mantenuto.
         */
        if (path.equals("/azione-forward")) {         
            request.getRequestDispatcher("/destinazione").forward(request, response);
            
            
            
            /* * REDIRECT (sendRedirect): 
             * - Avviene sul CLIENT (Browser).
             * - Il server invia un codice 302 e il browser fa una SECONDA richiesta.
             * - L'URL cambia visibilmente nella barra degli indirizzi.
             * - Si usa quando si cambia sito, quando si vuole evitare che l'utente 
             * faccia il "Refresh" di un form (Post-Redirect-Get) o dopo un logout.
             */
        } else if (path.equals("/azione-redirect")) {        
            response.sendRedirect(request.getContextPath() + "/destinazione");
            
        } else if (path.equals("/destinazione")) {
            // Pagina finale di arrivo
            response.setContentType("text/html");
            response.getWriter().println("<h1>Sei arrivato a destinazione!</h1>");
            response.getWriter().println("<p>Controlla l'URL nel browser e i DevTools.</p>");
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
