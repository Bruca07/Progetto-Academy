package com.academy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    // 1. Recupero i dati dal form
	    String user = request.getParameter("username");
	    String pass = request.getParameter("password");

	    // 2. Controllo le credenziali
	    if ("admin".equals(user) && "1234".equals(pass)) {
	        
	        // LOGIN CORRETTO
	        // Recuperiamo la sessione (se non esiste, viene creata)
	        javax.servlet.http.HttpSession session = request.getSession();
	        
	        // Salviamo l'username nella sessione
	        session.setAttribute("utenteLoggato", user);
	        
	        // Facciamo redirect alla dashboard (Punto 60 chiede redirect)
	        response.sendRedirect(request.getContextPath() + "/dashboard");
	        
	    } else {
	        
	        // LOGIN ERRATO
	        // Reindirizziamo al login con il parametro errore=1
	        response.sendRedirect("login.jsp?errore=1");
	    }

	}
}
