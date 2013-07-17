package uk.co.andrewmaddock.weddinggae.model;

import java.io.Serializable;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

/**
 * Playlist model object.
 *
 * @author Andrew Maddock
 *         Date: 12/07/13 15:03
 */
public class PlayList implements Serializable {

    private static final long serialVersionUID = 8467356953499282256L;
    
    @NotEmpty(message = "Requester cannot be empty")
    @Email(message = "Requester must be a valid email address")
    private String requester;

    @NotEmpty(message = "Artist cannot be empty")
    private String artist;

    @NotEmpty(message = "Track cannot be empty")
    private String track;

    @Size(max = 500, message = "Why must be less than 500 characters")
    private String why;

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("requester", this.getRequester())
                .append("artist", this.getArtist())
                .append("track", this.getTrack())
                .append("why", this.getWhy())
                .toString();
    }
    
}
