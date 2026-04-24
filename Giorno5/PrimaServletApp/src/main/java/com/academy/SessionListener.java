package com.academy;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
	 * Listener che monitora la creazione e distruzione delle sessioni.
	 * L'annotazione @WebListener serve a registrarlo automaticamente nel server.
	 */
	@WebListener
	public class SessionListener implements HttpSessionListener {

	    @Override
	    public void sessionCreated(HttpSessionEvent se) {
	        // Recuperiamo l'ID della sessione appena nata
	        String sessionId = se.getSession().getId();
	        System.out.println("==========================================");
	        System.out.println("LOG SESSIONE: CREATA");
	        System.out.println("ID Sessione: " + sessionId);
	        System.out.println("==========================================");
	    }

	    @Override
	    public void sessionDestroyed(HttpSessionEvent se) {
	        // Recuperiamo l'ID della sessione che sta per essere eliminata
	        String sessionId = se.getSession().getId();
	        System.out.println("==========================================");
	        System.out.println("LOG SESSIONE: DISTRUTTA (LOGOUT)");
	        System.out.println("ID Sessione: " + sessionId);
	        System.out.println("==========================================");
	    }
}
