package uk.co.andrewmaddock.weddinggae.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Domain object representing a rsvp.
 *
 * @author Andrew Maddock
 *         Date: 17/07/13 11:59
 */
@Entity 
public class Rsvp extends BaseEntity {

    private static final long serialVersionUID = -5212436493939200125L;

    @Id
    protected Long id;
    
    @NotEmpty
    @Size(max = 500)
    private String names;
    
    private boolean attending;
    
    @Min(value = 0) 
    @Max(value = 4)
    private int adults;

    @Min(value = 0)
    @Max(value = 4)
    private int children;
    
    private boolean transport;

    @Size(max = 500)
    private String messages;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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
                .append("id", this.getId())
                .append("names", this.getNames())
                .append("attending", this.isAttending())
                .append("adults", this.getAdults())
                .append("children", this.getChildren())
                .append("transport", this.isTransport())
                .append("messages", this.getMessages())
                .toString();
    }
    
}
