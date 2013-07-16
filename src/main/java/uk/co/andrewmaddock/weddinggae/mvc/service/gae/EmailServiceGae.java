package uk.co.andrewmaddock.weddinggae.mvc.service.gae;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import uk.co.andrewmaddock.weddinggae.model.PlayList;
import uk.co.andrewmaddock.weddinggae.mvc.helper.EmailHelper;
import uk.co.andrewmaddock.weddinggae.mvc.service.EmailService;

/**
 * Email Service MVC Gae.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 08:57
 */
@Service
public class EmailServiceGae implements EmailService {

    @Autowired
    private final EmailHelper helper = null;

    @Override
    public boolean send(PlayList playList) {
        boolean success = false;
        
        MimeMessageHelper mimeMessageHelper = helper.getMimeMessageHelper();

        String newLine = System.getProperty("line.separator");
        StringBuilder body = new StringBuilder().
                append("Playlist Item").append(newLine).append(newLine).
                append("Requester: ").append(playList.getRequester()).append(newLine).
                append("Artist: ").append(playList.getArtist()).append(newLine).
                append("Track: ").append(playList.getTrack()).append(newLine).
                append("Why: ").append(playList.getWhy()).append(newLine);
        
        try {
            mimeMessageHelper.addTo(playList.getRequester());
            mimeMessageHelper.setFrom("email@andrewmaddock.co.uk");
            mimeMessageHelper.setSubject("Test PlayList Send");
            mimeMessageHelper.setText(body.toString());

            success = helper.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            log.severe(e.toString());
        }

        return success;
    }
    
}
