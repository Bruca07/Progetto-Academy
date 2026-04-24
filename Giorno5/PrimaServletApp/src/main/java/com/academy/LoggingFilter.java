package com.academy;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoggingFilter
 */
@WebFilter("/*")
public class LoggingFilter extends HttpFilter implements Filter {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoggingFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // Messaggio opzionale per confermare l'avvio del filtro in console
        System.out.println("LoggingFilter: Inizializzato e attivo su /*");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // 1. Recuperiamo i dati base (Metodo e URL)
        String metodo = httpRequest.getMethod();
        String url = httpRequest.getRequestURL().toString();

        // 2. SALVIAMO IL TEMPO DI INIZIO (in millisecondi)
        long inizio = System.currentTimeMillis();

        // 3. LASCIAMO PASSARE LA RICHIESTA VERSO LA SERVLET
        // Tutto quello che succede da qui in poi viene cronometrato
        chain.doFilter(request, response);

        // 4. CALCOLIAMO IL TEMPO TRASCORSO
        long fine = System.currentTimeMillis();
        long durata = fine - inizio;

        // 5. STAMPIAMO TUTTO IN CONSOLE
        System.out.println("==========================================");
        System.out.println("LOG PRESTAZIONI");
        System.out.println("URL:      " + url);
        System.out.println("Metodo:   " + metodo);
        System.out.println("Durata:   " + durata + " ms"); // ms = millisecondi
        System.out.println("==========================================");
    }

    public void destroy() {
        // Pulizia finale (opzionale)
    }
	


	

	

}
