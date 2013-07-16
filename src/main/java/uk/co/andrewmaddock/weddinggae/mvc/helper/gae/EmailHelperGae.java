package uk.co.andrewmaddock.weddinggae.mvc.helper.gae;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import uk.co.andrewmaddock.weddinggae.mvc.helper.EmailHelper;

/**
 * Email Helper.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 13:43
 */
@Component
public class EmailHelperGae implements EmailHelper {

    @Autowired
    private final Session mailSession = null;

    @Override
    public MimeMessageHelper getMimeMessageHelper() {
        MimeMessage message = new MimeMessage(mailSession);
        return new MimeMessageHelper(message);
    }

    @Override
    public boolean send(MimeMessage message) {
       boolean success = false;
        
        try {
            Transport.send(message);
            success = true;
        } catch (MessagingException e) {
            log.severe(e.toString());
        }

        return success;
    }
    
}
