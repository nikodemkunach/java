package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
        carRepository.save(new Car("AUDI","GD723WR"));
    }

    public Car findCarByMake(String make){
        return this.carRepository.findCarByMake(make);
    }

    public Car findCarByRegistration(String registration){
        return this.carRepository.findCarByRegistration(registration);
    }

    public Optional<Car> findCarByID(Long id){
        return this.carRepository.findById(id);
    }

    public void saveCarToDB(Car car){
         this.carRepository.save(car);
    }
}
