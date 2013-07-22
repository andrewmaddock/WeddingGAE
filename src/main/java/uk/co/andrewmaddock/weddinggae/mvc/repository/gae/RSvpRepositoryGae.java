package uk.co.andrewmaddock.weddinggae.mvc.repository.gae;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import uk.co.andrewmaddock.weddinggae.model.Rsvp;
import uk.co.andrewmaddock.weddinggae.mvc.repository.RsvpRepository;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * GAE implementation of the {@link RsvpRepository} interface.
 *
 * @author Andrew Maddock
 *         Date: 18/07/13 13:42
 */
@Repository
public class RsvpRepositoryGae implements RsvpRepository {
    
    @Override
    public void save(Rsvp rsvp) throws DataAccessException {
        if (!rsvp.isAttending()) {
            notAttending(rsvp);
        }

//        Entity entity = new Entity(rsvp.getClass().getSimpleName());
//
//        entity.setProperty("names", rsvp.getNames());
//        entity.setProperty("attending", rsvp.isAttending());
//        entity.setProperty("adults", rsvp.getAdults());
//        entity.setProperty("children", rsvp.getChildren());
//        entity.setProperty("transport", rsvp.isTransport());
//        entity.setUnindexedProperty("messages", rsvp.getMessages());
      
        ofy().save().entity(rsvp);
    }

    private static void notAttending(Rsvp rsvp) {
        rsvp.setAdults(0);
        rsvp.setChildren(0);
        rsvp.setMessages("");
    }
    
}
