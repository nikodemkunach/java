package com.example.services;

import com.example.contract.AddressDto;
import com.example.model.Address;
import com.example.repositories.AddressRepository;
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
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<AddressDto> getAll() {
        List<AddressDto> addressDtoList = new ArrayList<>();
        for (Address address : addressRepository.findAll()){
            addressDtoList.add(new AddressDto(
                    address.getId(),
                    address.getCity(),
                    address.getPostalCode(),
                    address.getStreet()));
        }
        return addressDtoList;
    }

    public AddressDto getById(int id){
        Address address = addressRepository.findById(id).get();
        return new AddressDto(
                address.getId(),
                address.getCity(),
                address.getPostalCode(),
                address.getStreet());
    }

    public void save(AddressDto addressDto){
        addressRepository.save(new Address(
                addressDto.getId(),
                addressDto.getCity(),
                addressDto.getPostalCode(),
                addressDto.getStreet()));
    }

    public void update(AddressDto addressDto) {
        var address = addressRepository.findById(addressDto.getId()).orElse(null);
        if (address != null) {
            address.setCity(addressDto.getCity());
            address.setStreet(addressDto.getStreet());
            address.setPostalCode(addressDto.getPostalCode());
            addressRepository.save(address);
        }
    }

        public void delete(int addressId){
            addressRepository.findById(addressId).ifPresent(address -> addressRepository.deleteById(addressId));
        }
    }
