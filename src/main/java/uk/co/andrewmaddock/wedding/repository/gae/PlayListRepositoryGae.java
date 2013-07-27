package uk.co.andrewmaddock.wedding.repository.gae;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import uk.co.andrewmaddock.wedding.model.PlayList;
import uk.co.andrewmaddock.wedding.repository.PlayListRepository;

import static uk.co.andrewmaddock.wedding.repository.gae.OfyService.ofy;


/**
 * GAE implementation of the {@link PlayListRepository} interface.
 *
 * @author Andrew Maddock
 *         Date: 18/07/13 13:42
 */
@Repository
public class PlayListRepositoryGae implements PlayListRepository {

    @Override
    public void save(PlayList playList) throws DataAccessException {       
        ofy().save().entity(playList);
    }
    
}
