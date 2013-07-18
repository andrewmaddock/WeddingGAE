package uk.co.andrewmaddock.weddinggae.mvc.service.gae;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

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
    public boolean send(String to, String subject, String body) {
        boolean success = false;
        
        MimeMessageHelper mimeMessageHelper = helper.getMimeMessageHelper();
        
        try {
            mimeMessageHelper.addTo(to);
            mimeMessageHelper.setFrom(FROM_EMAIL);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body);

            success = helper.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            log.severe(e.toString());
        }

        return success;
    }
    
}
