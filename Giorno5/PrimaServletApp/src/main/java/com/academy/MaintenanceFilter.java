package com.academy;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MaintenanceFilter
 */
@WebFilter("/*")
public class MaintenanceFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

   
    private boolean IN_MANUTENZIONE = false;
    
    
    public MaintenanceFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        // 2. CAST DELLE RICHIESTE
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        String uri = httpRequest.getRequestURI();

        // 3. LOGICA DI CONTROLLO
        if (IN_MANUTENZIONE && !uri.contains("/manutenzione")) {
            System.out.println(">>> Filtro Manutenzione: Accesso negato, redirect in corso...");
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/manutenzione");
            return; 
        }

        chain.doFilter(request, response);
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
