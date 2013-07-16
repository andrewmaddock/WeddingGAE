package uk.co.andrewmaddock.weddinggae.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * RSVP MVC Controller.
 *
 * @author Andrew Maddock
 *         Date: 11/07/13 16:48
 */
@Controller
@RequestMapping(value = "/rsvp")
public class RsvpController {

    @RequestMapping(method = RequestMethod.GET)
    public String load() {
        return "rsvp/rsvp";
    }

}
