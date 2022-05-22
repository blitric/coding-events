package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("events")
public class EventController {
    @GetMapping
    public String displayAllEvents(Model model) {
        ArrayList<String> events = new ArrayList<>();
        events.add("event1");
        events.add("event2");
        events.add("event3");
        model.addAttribute("events", events);
return "events/index";
    }
}
