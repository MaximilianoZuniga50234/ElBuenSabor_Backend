package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.Person;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.PersonRepository;
import com.example.elbuensaborbackend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl extends BaseServiceImpl<Person, Long> implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonServiceImpl(BaseRepository<Person, Long> personRepository) {
        super(personRepository);
    }
}
