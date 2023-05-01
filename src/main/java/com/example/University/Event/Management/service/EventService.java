package com.example.University.Event.Management.service;

import com.example.University.Event.Management.module.Event;
import com.example.University.Event.Management.module.Student;
import com.example.University.Event.Management.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    IEventRepo iEventRepo;

    public Optional<Event> FetchEventData(String date) {
        return iEventRepo.findByDate(date);
    }

    public String InsertEvents(List<Event> student) {
        Iterable<Event> Added = iEventRepo.saveAll(student);
        if(Added != null){
            return "Added Successfully";
        }
        return "failed!!!";
    }

    public void DeleteEvents(Integer id) {
        iEventRepo.deleteById(id);
    }
    @Transactional
    public void UpdateEventsByDate(Integer id, String date) {
        iEventRepo.updateDateById(id,date);
    }
}
