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
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
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

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        // controller code will go here

        model.addAttribute("event", EventData.getById(eventId));
        String title = "Edit Event " +  EventData.getById(eventId).getName() + " (id=" + EventData.getById(eventId).getId() + ")";
        model.addAttribute("title", title);


        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        // controller code will go here
        EventData.getById(eventId).setName(name);
        EventData.getById(eventId).setDescription(description);
        return "redirect:";
    }

    @GetMapping("delete")
    public String renderDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Event");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }

        return "redirect:";
    }

}
