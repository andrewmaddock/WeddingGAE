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

import uk.co.andrewmaddock.weddinggae.model.PlayList;
import uk.co.andrewmaddock.weddinggae.mvc.service.PlayListService;

/**
 * Play List MVC Controller.
 *
 * @author Andrew Maddock
 *         Date: 11/07/13 16:48
 */
@Controller
@SessionAttributes("playlist")
@RequestMapping(value = "/playlist")
public class PlayListController {

    private final PlayListService playListService;

    @Autowired
    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        PlayList playlist = new PlayList();
        model.addAttribute("playlist", playlist);
        return "playlist/playlist";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("playlist") @Valid PlayList playlist, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "playlist/playlist";
        } else {
            playListService.save(playlist);
            playListService.email(playlist);
            status.setComplete();
            return "redirect:/playlist/confirm";    
        }
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirm() {
        return "playlist/playlistConfirm";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view() {
        return "playlist/playlistView";
    }

}
