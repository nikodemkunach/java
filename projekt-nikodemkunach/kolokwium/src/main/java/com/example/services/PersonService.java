package com.example.services;

import com.example.contract.PersonDto;
import com.example.model.Person;
import com.example.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor

public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public List<PersonDto> getAll() {
        List<PersonDto> personDtoList = new ArrayList<>();
        for (Person person : personRepository.findAll()) {
            personDtoList.add(new PersonDto(
                    person.getId(),
                    person.getFirstName(),
                    person.getLastName()));
        }
        return personDtoList;
    }

    public PersonDto getbyId(int id){
        Person person = personRepository.findById(id).get();
        return new PersonDto(
                person.getId(),
                person.getFirstName(),
                person.getLastName());
    }

    public void save(PersonDto personDto) {
        personRepository.save(new Person(
                personDto.getId(),
                personDto.getFirstName(),
                personDto.getLastName()));
    }

    public void update(PersonDto personDto) {
        var person = personRepository.findById(personDto.getId()).orElse(null);
        if (person != null) {
            person.setFirstName(personDto.getFirstName());
            person.setLastName(personDto.getLastName());
            personRepository.save(person);
        }
    }

    public void delete(int personId) {
        personRepository.findById(personId).ifPresent(person -> personRepository.deleteById(personId));
    }

}