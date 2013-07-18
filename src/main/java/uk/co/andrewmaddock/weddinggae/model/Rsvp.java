package uk.co.andrewmaddock.weddinggae.model;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

/**
 * Rsvp model object.
 *
 * @author Andrew Maddock
 *         Date: 17/07/13 11:59
 */
public class Rsvp implements Serializable {

    private static final long serialVersionUID = -5212436493939200125L;

    @NotEmpty(message = "Names cannot be empty")
    @Size(max = 500, message = "Names must be less than 500 characters")
    private String names;
    
    private boolean attending;
    
    @Min(value = 0, message = "Number of adults cannot be less than 0") 
    @Max(value = 4, message = "Number of adults cannot be more than 4")
    private int adults;

    @Min(value = 0, message = "Number of children cannot be less than 0")
    @Max(value = 4, message = "Number of children cannot be more than 4")
    private int children;
    
    private boolean transport;

    @Size(max = 500, message = "Messages must be less than 500 characters")
    private String messages;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public boolean isAttending() {
        return attending;
    }

    public void setAttending(boolean attending) {
        this.attending = attending;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public boolean isTransport() {
        return transport;
    }

    public void setTransport(boolean transport) {
        this.transport = transport;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("names", this.getNames())
                .append("attending", this.isAttending())
                .append("adults", this.getAdults())
                .append("children", this.getChildren())
                .append("transport", this.isTransport())
                .append("messages", this.getMessages())
                .toString();
    }
    
}
