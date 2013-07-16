package uk.co.andrewmaddock.weddinggae.mvc.service.gae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.andrewmaddock.weddinggae.model.PlayList;
import uk.co.andrewmaddock.weddinggae.mvc.service.EmailService;
import uk.co.andrewmaddock.weddinggae.mvc.service.PlayListService;

/**
 * Play List MVC Service.
 *
 * @author Andrew Maddock
 *         Date: 12/07/13 15:04
 */
@Service
public class PlayListServiceGae implements PlayListService {
    
    @Autowired
    private final EmailService emailService = null; 
    
    @Override
    public boolean email(PlayList playList) {
        log.info("PlayListService.email(): " + playList);
        return emailService.send(playList);
    }
    
}
