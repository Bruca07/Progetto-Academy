package com.academy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProdottiServlet
 */
@WebServlet("/Prodotti")
public class ProdottiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdottiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Creiamo la lista con i prodotti
        List<Prodotto> lista = new ArrayList<>();
        
        lista.add(new Prodotto());
        lista.get(0).setNome("MacBook Pro"); lista.get(0).setPrezzo(1999.99); lista.get(0).setDisponibile(true);
        
        lista.add(new Prodotto());
        lista.get(1).setNome("iPhone 15"); lista.get(1).setPrezzo(999.00); lista.get(1).setDisponibile(true);
        
        lista.add(new Prodotto());
        lista.get(2).setNome("AirPods"); lista.get(2).setPrezzo(150.50); lista.get(2).setDisponibile(false);
        
        lista.add(new Prodotto());
        lista.get(3).setNome("Kindle"); lista.get(3).setPrezzo(120.00); lista.get(3).setDisponibile(true);
        
        lista.add(new Prodotto());
        lista.get(4).setNome("Monitor Dell"); lista.get(4).setPrezzo(350.00); lista.get(4).setDisponibile(false);

        // --- PUNTO 76: Calcolo totali e media ---
        double sommaPrezzi = 0;
        for (Prodotto p : lista) {
            sommaPrezzi += p.getPrezzo();
        }
        
        int numeroProdotti = lista.size();
        double prezzoMedio = sommaPrezzi / numeroProdotti;

        // 2. Salviamo i dati nella request
        request.setAttribute("elencoProdotti", lista);
        request.setAttribute("totalePrezzi", sommaPrezzi);
        request.setAttribute("numeroProdotti", numeroProdotti);
        request.setAttribute("prezzoMedio", prezzoMedio);

        // 3. Facciamo il forward alla JSP
        request.getRequestDispatcher("lista-prodotti.jsp").forward(request, response);
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
