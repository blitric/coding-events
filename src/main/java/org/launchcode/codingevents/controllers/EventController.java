package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("events")
public class EventController {
    private static ArrayList<String> events = new ArrayList<>();
    @GetMapping
    public String displayAllEvents(Model model) {
        /*ArrayList<String> events = new ArrayList<>();
        events.add("event1");
        events.add("event2");
        events.add("event3");
        model.addAttribute("events", events); */
        model.addAttribute("events", events);
return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }


    @PostMapping("create")
    public String createEvent( @RequestParam String eventName) {
        events.add(eventName);
        return "redirect:";

    }

}
