package uk.co.andrewmaddock.weddinggae.mvc.repository.gae;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import uk.co.andrewmaddock.weddinggae.model.PlayList;
import uk.co.andrewmaddock.weddinggae.mvc.repository.PlayListRepository;

import static com.googlecode.objectify.ObjectifyService.ofy;

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
//        Entity entity = new Entity(playList.getClass().getSimpleName());
//
////        entity.setProperty("requester", new Email(playlist.getRequester()));
//        entity.setProperty("requester", playList.getRequester());
//        entity.setProperty("artist", playList.getArtist());
//        entity.setProperty("track", playList.getTrack());
//        entity.setUnindexedProperty("why", playList.getWhy());
         
        ofy().save().entity(playList);
    }
    
}
