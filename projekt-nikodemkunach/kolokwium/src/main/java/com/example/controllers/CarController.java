package com.example.controllers;

import com.example.contract.CarDto;
import com.example.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("api/v1/car")
    public List<CarDto> getAll(){
        return carService.getAll();
    }
    @PostMapping("api/v1/car")
    public void save(@RequestBody CarDto carDto){
        carService.save(carDto);
    }

    @GetMapping("api/v1/car/{id}")
    public CarDto carDto(@PathVariable Integer id){
        return carService.getAll().stream()
                .filter(carDto -> carDto.getId().equals(id))
                .findAny().orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "didn't find car"));
    }

    @PutMapping("api/v1/car/{id}")
    public void updateCar(@PathVariable Integer id, @RequestBody CarDto newCarDto){
        if(carService.getCarRepository().findById(id).isEmpty()){
            throw new ResponseStatusException(NOT_FOUND, "didn't find car");
        }else {
            newCarDto.setId(id);
            carService.update(newCarDto);
        }
    }

    @DeleteMapping("api/v1/car/{id}")
    public void deleteCar(@PathVariable Integer id){
        if(carService.getCarRepository().findById(id).isEmpty()){
            throw new ResponseStatusException(NOT_FOUND, "didn't find car");
        }else {
            carService.delete(id);
        }
    }
}
