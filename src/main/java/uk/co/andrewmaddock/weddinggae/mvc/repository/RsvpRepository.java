package uk.co.andrewmaddock.weddinggae.mvc.repository;

import org.springframework.dao.DataAccessException;

import uk.co.andrewmaddock.weddinggae.model.Rsvp;

/**
 * Repository class for <code>Rsvp</code> domain objects.
 *
 * @author Andrew Maddock
 *         Date: 18/07/13 13:36
 */
public interface RsvpRepository {

    void save(Rsvp rsvp) throws DataAccessException; 
    
}
