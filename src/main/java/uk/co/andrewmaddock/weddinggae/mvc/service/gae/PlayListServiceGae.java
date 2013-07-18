package uk.co.andrewmaddock.weddinggae.mvc.service.gae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
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
    private DatastoreService datastore = null;
    
    @Autowired
    private final EmailService emailService = null; 
    
    @Override
    public boolean email(PlayList playList) {
        log.info(this.getClass().getCanonicalName() + " email: " + playList);
        return emailService.send(
                playList.getRequester(), 
                "Test " + this.getClass().getName() + " Send",
                emailBody(playList));
    }

    @Override
    public boolean save(PlayList playlist) {
        log.info(this.getClass().getCanonicalName() + ".save(): " + playlist);
        
        Entity entity = new Entity(playlist.getClass().getSimpleName());
        
//        entity.setProperty("requester", new Email(playlist.getRequester()));
        entity.setProperty("requester", playlist.getRequester());
        entity.setProperty("artist", playlist.getArtist());
        entity.setProperty("track", playlist.getTrack());
        entity.setProperty("why", playlist.getWhy());

        datastore.put(entity);
        
        return true;
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
