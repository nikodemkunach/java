package com.example.controllers;

import com.example.contract.AddressDto;
import com.example.contract.PersonDto;
import com.example.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("api/v1/person")
    public List<PersonDto> getAll() {
        return personService.getAll();
    }
    @PostMapping("api/v1/person")
    public void save(@RequestBody PersonDto personDto){
        personService.save(personDto);
    }

    @GetMapping("api/v1/person/{id}")
    public PersonDto getPerson(@PathVariable Integer id) {
        return personService.getAll().stream()
                .filter(personDto -> personDto.getId().equals(id))
                .findAny().orElseThrow(()->new ResponseStatusException(NOT_FOUND, "didn't find person"));
    }
    @PutMapping("api/vi/person/{id}")
    public void updatePerson(@PathVariable Integer id, @RequestBody PersonDto newPersonDto){
        if(personService.getPersonRepository().findById(id).isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, "didn't find person");
        }else {
            newPersonDto.setId(id);
            personService.update(newPersonDto);
        }
    }
    @DeleteMapping("api/v1/person/{id}")
    public void deletePerson(@PathVariable Integer id){
        if(personService.getPersonRepository().findById(id).isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, "didn't find person");
        }else {
            personService.delete(id);
        }
    }

    @GetMapping("api/v1/person/{id}/addresses")
    public List<AddressDto> getAddress(@PathVariable Integer id){
        var address = personService.getAddresses(id);
        if(address.isEmpty()){
            throw new ResponseStatusException(NOT_FOUND, "didn't find address");
        }else{
            return address;
        }
    }
    @PostMapping("api/v1/person/{id}/addresses")
    public void addAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto){
        if(personService.getPersonRepository().findById(id).isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, "didn't find person");
        }else {
            personService.addAddress(id,addressDto);
        }
    }

}
