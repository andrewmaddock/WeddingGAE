package uk.co.andrewmaddock.weddinggae.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import uk.co.andrewmaddock.weddinggae.model.Rsvp;
import uk.co.andrewmaddock.weddinggae.mvc.service.RsvpService;

/**
 * RSVP MVC Controller.
 *
 * @author Andrew Maddock
 *         Date: 11/07/13 16:48
 */
@Controller
@SessionAttributes("rsvp")
@RequestMapping(value = "/rsvp")
public class RsvpController {

    private final RsvpService rsvpService;

    @Autowired
    public RsvpController(RsvpService rsvpService) {
        this.rsvpService = rsvpService;
    }

    @RequestMapping(method = RequestMethod.GET)  
    public String init(Model model) {
        Rsvp rsvp = new Rsvp();
        rsvp.setAttending(true);
        model.addAttribute("rsvp", rsvp);
        return "rsvp/rsvp";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("rsvp") @Valid Rsvp rsvp, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "rsvp/rsvp";
        } else {
            if (rsvpService.save(rsvp) && rsvpService.email(rsvp)) {
                status.setComplete();
                return "redirect:/rsvp/confirm";
            } else {
                return "rsvp/rsvp";
            }
        }
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirm() {
        return "rsvp/rsvpConfirm";
    }

}
