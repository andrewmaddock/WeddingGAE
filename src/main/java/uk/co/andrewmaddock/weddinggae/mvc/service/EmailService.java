package uk.co.andrewmaddock.weddinggae.mvc.service;

import java.util.logging.Logger;

import org.springframework.web.servlet.DispatcherServlet;

import uk.co.andrewmaddock.weddinggae.model.PlayList;

/**
 * Email Service Interface.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 08:56
 */
public interface EmailService {

    static final Logger log = Logger.getLogger(DispatcherServlet.class.getName());
    
    boolean send(PlayList playList);
    
}
