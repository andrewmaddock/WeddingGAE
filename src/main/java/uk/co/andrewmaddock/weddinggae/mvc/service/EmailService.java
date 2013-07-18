package uk.co.andrewmaddock.weddinggae.mvc.service;

import java.util.logging.Logger;

import org.springframework.web.servlet.DispatcherServlet;

/**
 * Email Service Interface.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 08:56
 */
public interface EmailService {

    static final Logger log = Logger.getLogger(DispatcherServlet.class.getName());

    static final String FROM_EMAIL = "email@andrewmaddock.co.uk";
    
    boolean send(String to, String subject, String body);
    
}
