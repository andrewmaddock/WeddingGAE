package uk.co.andrewmaddock.weddinggae.mvc.service.gae;

import org.springframework.stereotype.Service;

import uk.co.andrewmaddock.weddinggae.model.Rsvp;
import uk.co.andrewmaddock.weddinggae.mvc.service.RsvpService;

/**
 * Play List MVC Service.
 *
 * @author Andrew Maddock
 *         Date: 12/07/13 15:04
 */
@Service
public class RsvpServiceGae implements RsvpService {
    
//    @Autowired
//    private final EmailService emailService = null; 
    
    @Override
    public boolean email(Rsvp rsvp) {
        log.info(this.getClass().getCanonicalName() + ".email: " + rsvp);
        return true;        
//        return emailService.send(rsvp);
    }
    
}
