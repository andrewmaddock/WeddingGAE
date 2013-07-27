package uk.co.andrewmaddock.wedding.service.gae;

import com.google.appengine.api.mail.MailService;
import com.google.appengine.api.utils.SystemProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.andrewmaddock.wedding.service.EmailService;
import uk.co.andrewmaddock.wedding.service.ServiceException;

import java.io.IOException;

import static com.google.appengine.api.mail.MailService.Message;

/**
 * Email Service MVC Gae.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 08:57
 */
@Service
public class EmailServiceGae implements EmailService {

    public static final String SENDER_EMAIL = "donotreply@" + SystemProperty.applicationId.get() + ".appspotmail.com";
    
    private final MailService mailService;

    @Autowired
    public EmailServiceGae(MailService mailService) {
        this.mailService = mailService;    
    }
    
    @Override
    public void send(String to, String subject, String body) throws ServiceException {
        try {
            Message message = new Message(SENDER_EMAIL, to, subject, body);
            mailService.send(message);
        } catch (IOException e) {
            log.severe(e.toString());
            throw new ServiceException(e);
        }
    }

    @Override
    public void sendHtml(String to, String subject, String htmlBody) throws ServiceException {
        try {
            Message message = new Message(SENDER_EMAIL, to, subject, null);
            message.setHtmlBody(htmlBody);
            mailService.send(message);
        } catch (IOException e) {
            log.severe(e.toString());
            throw new ServiceException(e);
        }
    }

    @Override
    public void sendToAdmins(String subject, String body) throws ServiceException {
        try {
            Message message = new Message(SENDER_EMAIL, SENDER_EMAIL, subject, body);
            mailService.sendToAdmins(message);
        } catch (IOException e) {
            log.severe(e.toString());
            throw new ServiceException(e);
        }
    }

    @Override
    public void sendHtmlToAdmins(String subject, String htmlBody) throws ServiceException {
        try {
            Message message = new Message(SENDER_EMAIL, SENDER_EMAIL, subject, null);
            message.setHtmlBody(htmlBody);
            mailService.sendToAdmins(message);
        } catch (IOException e) {
            log.severe(e.toString());
            throw new ServiceException(e);
        }
    }

}
