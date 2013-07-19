package uk.co.andrewmaddock.weddinggae.mvc.repository;

import org.springframework.dao.DataAccessException;

import uk.co.andrewmaddock.weddinggae.model.PlayList;

/**
 * Repository class for <code>PlayList</code> domain objects.
 *
 * @author Andrew Maddock
 *         Date: 18/07/13 13:36
 */
public interface PlayListRepository {

    void save(PlayList playList) throws DataAccessException; 
    
}
