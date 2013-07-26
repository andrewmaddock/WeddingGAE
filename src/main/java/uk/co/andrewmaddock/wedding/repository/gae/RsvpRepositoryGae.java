package uk.co.andrewmaddock.wedding.repository.gae;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import uk.co.andrewmaddock.wedding.model.Rsvp;
import uk.co.andrewmaddock.wedding.repository.RsvpRepository;

/**
 * GAE implementation of the {@link uk.co.andrewmaddock.wedding.repository.RsvpRepository} interface.
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
      
        OfyService.ofy().save().entity(rsvp);
    }

    private static void notAttending(Rsvp rsvp) {
        rsvp.setAdults(0);
        rsvp.setChildren(0);
        rsvp.setMessages("");
    }
    
}
