package uk.co.andrewmaddock.weddinggae.mvc.service;

/**
 * Service Exception.
 *
 * @author Andrew Maddock
 *         Date: 16/07/13 13:49
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = -3916879763155516855L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
