package uk.co.andrewmaddock.weddinggae.mvc.service.gae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import uk.co.andrewmaddock.weddinggae.model.PlayList;
import uk.co.andrewmaddock.weddinggae.mvc.repository.PlayListRepository;
import uk.co.andrewmaddock.weddinggae.mvc.service.EmailService;
import uk.co.andrewmaddock.weddinggae.mvc.service.PlayListService;
import uk.co.andrewmaddock.weddinggae.mvc.service.ServiceException;

/**
 * Play List MVC Service.
 *
 * @author Andrew Maddock
 *         Date: 12/07/13 15:04
 */
@Service
public class PlayListServiceGae implements PlayListService {

    private final PlayListRepository playListRepository;
    private final EmailService emailService;

    @Autowired
    public PlayListServiceGae(PlayListRepository playListRepository, EmailService emailService) {
        this.playListRepository = playListRepository;
        this.emailService = emailService;
    }
    
    @Override
    public void email(PlayList playList) throws ServiceException {
        log.info(this.getClass().getCanonicalName() + " email: " + playList);
        emailService.send(
                playList.getRequester(), 
                "Test " + this.getClass().getSimpleName() + " Send",
                emailBody(playList));
    }

    @Override
    public void save(PlayList playlist) throws DataAccessException {
        log.info(this.getClass().getCanonicalName() + " save: " + playlist);
        playListRepository.save(playlist);
    }
    
    private static String emailBody(PlayList playList) {
        String newLine = System.getProperty("line.separator");
        StringBuilder body = new StringBuilder().
                append("Playlist Item").append(newLine).append(newLine).
                append("Requester: ").append(playList.getRequester()).append(newLine).
                append("Artist: ").append(playList.getArtist()).append(newLine).
                append("Track: ").append(playList.getTrack()).append(newLine).
                append("Why: ").append(playList.getWhy()).append(newLine);
        return body.toString();
    }
    
}
