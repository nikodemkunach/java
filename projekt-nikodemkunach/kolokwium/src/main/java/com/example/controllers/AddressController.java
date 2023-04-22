package com.example.controllers;

import com.example.contract.AddressDto;
import com.example.model.Address;
import com.example.services.AddressService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("api/v1/address")
    public List<AddressDto> getAll(){
        return addressService.getAll();
    }
    @PostMapping("api/v1/address")
    public void save(@RequestBody AddressDto addressDto){
        addressService.save(addressDto);
    }

    @GetMapping("api/v1/address/{id}")
    public AddressDto getAddress(@PathVariable Integer id){
        return addressService.getAll().stream()
                .filter(addressDto -> addressDto.getId().equals(id))
                .findAny().orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "didn't find address"));
    }
    @PutMapping("api/v1/address/{id}")
    public void updateAddress(@PathVariable Integer id, @RequestBody AddressDto newAddressDto){
        if(addressService.getAddressRepository().findById(id).isEmpty()){
            throw new ResponseStatusException(NOT_FOUND, "didn't find address");
        }else {
            newAddressDto.setId(id);
            addressService.update(newAddressDto);
        }
    }
    @DeleteMapping("api/v1/address/{id}")
    public void deleteAddress(@PathVariable Integer id){
        if(addressService.getAddressRepository().findById(id).isEmpty()){
            throw new ResponseStatusException(NOT_FOUND, "didn't find address");
        }else {
            addressService.delete(id);
        }
    }

}
