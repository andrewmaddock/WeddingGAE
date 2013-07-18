package uk.co.andrewmaddock.weddinggae.mvc.service.gae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import uk.co.andrewmaddock.weddinggae.model.Rsvp;
import uk.co.andrewmaddock.weddinggae.mvc.service.EmailService;
import uk.co.andrewmaddock.weddinggae.mvc.service.RsvpService;

import static uk.co.andrewmaddock.weddinggae.mvc.service.EmailService.FROM_EMAIL;

/**
 * Play List MVC Service.
 *
 * @author Andrew Maddock
 *         Date: 12/07/13 15:04
 */
@Service
public class RsvpServiceGae implements RsvpService {

    @Autowired
    private DatastoreService datastore = null;
    
    @Autowired
    private final EmailService emailService = null;

    @Override
    public boolean email(Rsvp rsvp) {
        log.info(this.getClass().getCanonicalName() + " email: " + rsvp);
        return emailService.send(
                FROM_EMAIL,
                "Test " + this.getClass().getName() + " Send",
                emailBody(rsvp));
    }

    @Override
    public boolean save(Rsvp rsvp) {
        if (!rsvp.isAttending()) {
            notAttending(rsvp);
        }
                
        Entity entity = new Entity(rsvp.getClass().getSimpleName());
        
        entity.setProperty("names", rsvp.getNames());
        entity.setProperty("attending", rsvp.isAttending());
        entity.setProperty("adults", rsvp.getAdults());
        entity.setProperty("children", rsvp.getChildren());
        entity.setProperty("transport", rsvp.isTransport());
        entity.setProperty("messages", rsvp.getMessages());

        datastore.put(entity);
        
        return true;
    }

    private static void notAttending(Rsvp rsvp) {
        rsvp.setAdults(0);
        rsvp.setChildren(0);
        rsvp.setMessages("");
    }

    private static String emailBody(Rsvp rsvp) {
        String newLine = System.getProperty("line.separator");
        StringBuilder body = new StringBuilder().
                append("RSVP").append(newLine).append(newLine).
                append("Names: ").append(rsvp.getNames()).append(newLine). 
                append("Attending: ").append(rsvp.isAttending()).append(newLine). 
                append("Adults: ").append(rsvp.getAdults()).append(newLine). 
                append("Children: ").append(rsvp.getChildren()).append(newLine). 
                append("Transport: ").append(rsvp.isTransport()).append(newLine). 
                append("Messages: ").append(rsvp.getMessages()).append(newLine); 
        return body.toString();
    }

}
