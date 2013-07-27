package uk.co.andrewmaddock.wedding.service.gae;

import com.google.appengine.api.mail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static com.google.appengine.api.mail.MailService.Message;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.IsCollectionContaining.hasItem;
import static org.mockito.Mockito.verify;

/**
 * EmailServiceGae Test.
 *
 * @author Andrew Maddock
 *         Date: 27/07/13 16:38
 */
@RunWith(MockitoJUnitRunner.class)
public class EmailServiceGaeTest {

    private static final String TO = "toEmail";
    private static final String SUBJECT = "subject";
    private static final String BODY = "body";

    @InjectMocks
    private final EmailServiceGae service = null;

    @Mock
    private MailService mailService = null;

    @Captor
    private ArgumentCaptor<Message> messageCaptor = null;

    @Test
    public void sendCreatesMessageAndCallsMailService() throws IOException {
        service.send(TO, SUBJECT, BODY);

        verify(mailService).send(messageCaptor.capture());
        assertThat(messageCaptor.getValue().getSender(), is(EmailServiceGae.SENDER_EMAIL));
        assertThat(messageCaptor.getValue().getTo(), hasItem(TO));
        assertThat(messageCaptor.getValue().getSubject(), is(SUBJECT));
        assertThat(messageCaptor.getValue().getTextBody(), is(BODY));
        assertThat(messageCaptor.getValue().getHtmlBody(), nullValue());
    }


}
