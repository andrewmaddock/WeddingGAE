package uk.co.andrewmaddock.weddinggae.mvc.service;

import java.util.logging.Logger;

import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.DispatcherServlet;

import uk.co.andrewmaddock.weddinggae.model.Rsvp;

/**
 * Play List Service Interface.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 08:43
 */
public interface RsvpService {

    final static Logger log = Logger.getLogger(DispatcherServlet.class.getName());
    
    void email(Rsvp rsvp) throws ServiceException;
    
    void save(Rsvp rsvp) throws DataAccessException;
    
}
