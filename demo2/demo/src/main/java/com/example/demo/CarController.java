package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CarController {
    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("car/id/{id}")
    public Optional<Car> getCarByID(@PathVariable Long id){
        return carService.findCarByID(id);
    }

    @GetMapping("car/make/{make}")
    public Car getCarByMake(@PathVariable String make){
        return carService.findCarByMake(make);
    }

    @GetMapping("car/registration/{registration}")
    public Car getCarByRegistration(@PathVariable String registration){
        return carService.findCarByRegistration(registration);
    }

    @PostMapping("/request")
    public void postController(@RequestBody Car car){
        carService.saveCarToDB(car);
    }
}

