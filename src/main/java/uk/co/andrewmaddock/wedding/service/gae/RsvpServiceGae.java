package uk.co.andrewmaddock.wedding.service.gae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import uk.co.andrewmaddock.wedding.model.Rsvp;
import uk.co.andrewmaddock.wedding.repository.RsvpRepository;
import uk.co.andrewmaddock.wedding.service.EmailService;
import uk.co.andrewmaddock.wedding.service.RsvpService;
import uk.co.andrewmaddock.wedding.service.ServiceException;

/**
 * Play List MVC Service.
 *
 * @author Andrew Maddock
 *         Date: 12/07/13 15:04
 */
@Service
public class RsvpServiceGae implements RsvpService {
    
    private final RsvpRepository rsvpRepository;
    private final EmailService emailService;

    @Autowired
    public RsvpServiceGae(RsvpRepository rsvpRepository, EmailService emailService) {
        this.rsvpRepository = rsvpRepository;
        this.emailService = emailService;
    }

    @Override
    public void email(Rsvp rsvp) throws ServiceException {
        log.info(this.getClass().getCanonicalName() + " email: " + rsvp);
        emailService.sendToAdmins(
                "Test " + this.getClass().getSimpleName() + " Send",
                emailBody(rsvp));
    }

    @Override
    public void save(Rsvp rsvp) throws DataAccessException {
        log.info(this.getClass().getCanonicalName() + " save: " + rsvp);
        rsvpRepository.save(rsvp);
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
