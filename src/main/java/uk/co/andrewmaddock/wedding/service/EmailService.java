package uk.co.andrewmaddock.wedding.service;

import org.springframework.web.servlet.DispatcherServlet;

import java.util.logging.Logger;

/**
 * Email Service Interface.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 08:56
 */
public interface EmailService {

    static final Logger log = Logger.getLogger(DispatcherServlet.class.getName());
    
    void send(String to, String subject, String body) throws ServiceException;
    
    void sendHtml(String to, String subject, String htmlBody) throws ServiceException;   
    
    void sendToAdmins(String subject, String body) throws ServiceException;
    
    void sendHtmlToAdmins(String subject, String htmlBody) throws ServiceException;
    
}
