package uk.co.andrewmaddock.weddinggae.mvc.repository.gae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import uk.co.andrewmaddock.weddinggae.model.Rsvp;
import uk.co.andrewmaddock.weddinggae.mvc.repository.RsvpRepository;

/**
 * GAE implementation of the {@link RsvpRepository} interface.
 *
 * @author Andrew Maddock
 *         Date: 18/07/13 13:42
 */
@Repository
public class RsvpRepositoryGae implements RsvpRepository {

    private DatastoreService datastore;

    @Autowired
    public RsvpRepositoryGae(DatastoreService datastore) {
        this.datastore = datastore;        
    }
    
    @Override
    public void save(Rsvp rsvp) throws DataAccessException {
        if (!rsvp.isAttending()) {
            notAttending(rsvp);
        }

        Entity entity = new Entity(rsvp.getClass().getSimpleName());

        entity.setProperty("names", rsvp.getNames());
        entity.setProperty("attending", rsvp.isAttending());
        entity.setProperty("adults", rsvp.getAdults());
        entity.setProperty("children", rsvp.getChildren());
        entity.setProperty("transport", rsvp.isTransport());
        entity.setUnindexedProperty("messages", rsvp.getMessages());
        
        datastore.put(entity);
    }

    private static void notAttending(Rsvp rsvp) {
        rsvp.setAdults(0);
        rsvp.setChildren(0);
        rsvp.setMessages("");
    }
    
}
