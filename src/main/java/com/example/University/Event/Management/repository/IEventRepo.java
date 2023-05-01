package com.example.University.Event.Management.repository;

import com.example.University.Event.Management.module.Event;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEventRepo extends CrudRepository<Event,Integer>{

    //custom finder by date
    public Optional<Event> findByDate(String date);


//    custom query
    @Modifying
    @Query(value = "update event set date = :date where event_id = :id" , nativeQuery = true)
    public void updateDateById(Integer id,String date);



}
