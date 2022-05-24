package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;


@Controller
@RequestMapping("events")
public class EventController {
    private static HashMap<String, String> events =  new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        /*ArrayList<String> events = new ArrayList<>();
        events.add("event1");
        events.add("event2");
        events.add("event3");
        model.addAttribute("events", events); */
      /*  model.addAttribute("events", events);
return "events/index"; */
events.put("Learn JavaScript for Free", "Join us to take this Live Free Course and build a working app within 1 hour.");
events.put("Computer Coding - Virtual (May)", "Create anything you can imagine with Roblox's immersive video game engine!");
events.put("Online Class: Scratch Coding Basics", "Learn how to program and make your own interactive games!");
model.addAttribute("events", events);
return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }


   /* @PostMapping("create")
    public String createEvent( @RequestParam String eventName) {
        events.add(eventName);
        return "redirect:";

    } */

}
