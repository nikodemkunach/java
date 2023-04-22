package com.example.services;

import com.example.contract.AddressDto;
import com.example.contract.PersonDto;
import com.example.model.Address;
import com.example.model.Person;
import com.example.repositories.AddressRepository;
import com.example.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @Autowired
    private AddressRepository addressRepository;


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

    public void addAddress(int personId, AddressDto addressDto) {
        var person = personRepository.findById(personId).orElse(null);
        if (person != null) {
            var address = new Address();
            address.setId(addressDto.getId());
            address.setCity(addressDto.getCity());
            address.setPostalCode(addressDto.getPostalCode());
            address.setStreet(addressDto.getStreet());
            address.setPerson(person);
            person.getAddress().add(address);
            addressRepository.save(address);
            personRepository.save(person);
        }
    }

    public List<AddressDto> getAddresses(int personId) {
        List<AddressDto> addressDtoList = new ArrayList<>();
        var person = personRepository.findById(personId).orElse(null);
        if (person != null) {
            var addresses = person.getAddress();
            for (Address address : addresses) {
                addressDtoList.add(new AddressDto(
                        address.getId(),
                        address.getCity(),
                        address.getPostalCode(),
                        address.getStreet()));
            }
        }
        return addressDtoList;
    }
}