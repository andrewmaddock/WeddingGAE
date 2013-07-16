package uk.co.andrewmaddock.weddinggae.mvc.helper;

import java.util.logging.Logger;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Email Helper Interface.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 13:44
 */
public interface EmailHelper {

    static final Logger log = Logger.getLogger(DispatcherServlet.class.getName());
    
    MimeMessageHelper getMimeMessageHelper();
    
    boolean send(MimeMessage message);
    
}
