package com.example.University.Event.Management.controller;

import com.example.University.Event.Management.module.Event;
import com.example.University.Event.Management.module.Student;
import com.example.University.Event.Management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping(value = "/events/date{date}")
    public Optional<Event> GetEvents(@PathVariable String date){
        return eventService.FetchEventData(date);
    }

    @PostMapping(value = "/events")
    public String AddStudents(@RequestBody List<Event> Student) {
        return eventService.InsertEvents(Student);
    }

    @DeleteMapping(value = "/events/ID/{ID}")
    public void DeleteByEventsName(@PathVariable Integer ID){
        eventService.DeleteEvents(ID);
    }
    @PutMapping(value = "/events/Id/{ID}/Date{date}")
    public void UpdateEventsByDepartment(@PathVariable Integer ID,@PathVariable String date){
        eventService.UpdateEventsByDate(ID,date);
    }
}
