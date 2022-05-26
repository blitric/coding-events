package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
    //private static ArrayList<String> events = new ArrayList<>();
   // private static List<Event> events = new ArrayList<>();
    @GetMapping
    public String displayAllEvents(Model model) {
        /*ArrayList<String> events = new ArrayList<>();
        events.add("event1");
        events.add("event2");
        events.add("event3");
        model.addAttribute("events", events); */
        model.addAttribute("events", EventData.getAll());
return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }


    @PostMapping("create")
    //public String createEvent( @RequestParam String eventName, @RequestParam String eventDescription) {
    public String createEvent( @ModelAttribute Event newEvent) {
        //events.add(new Event(eventName, eventDescription));
        //EventData.add(new Event(eventName, eventDescription));
        EventData.add(newEvent);
        return "redirect:";

    }

}
