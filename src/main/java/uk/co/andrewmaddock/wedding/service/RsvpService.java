package uk.co.andrewmaddock.wedding.service;

import java.util.logging.Logger;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.DispatcherServlet;

import uk.co.andrewmaddock.wedding.model.Rsvp;

/**
 * Play List Service Interface.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 08:43
 */
public interface RsvpService {

    final static Logger log = Logger.getLogger(DispatcherServlet.class.getName());

    @Transactional
    void email(Rsvp rsvp) throws ServiceException;

    @Transactional
    void save(Rsvp rsvp) throws DataAccessException;
    
}