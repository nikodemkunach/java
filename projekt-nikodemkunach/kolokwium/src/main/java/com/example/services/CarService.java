package com.example.services;

import com.example.contract.CarDto;
import com.example.model.Car;
import com.example.repositories.CarRepository;
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

public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarDto> getAll(){
        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : carRepository.findAll()){
            carDtoList.add(new CarDto(
                    car.getId(),
                    car.getMake(),
                    car.getModel(),
                    car.getPyear()));
        }
        return carDtoList;
    }

    public CarDto getById(int id){
        Car car = carRepository.findById(id).get();
        return new CarDto(
                car.getId(),
                car.getMake(),
                car.getModel(),
                car.getPyear());
    }

    public void save(CarDto carDto){
        carRepository.save(new Car(
                carDto.getId(),
                carDto.getMake(),
                carDto.getModel(),
                carDto.getPyear()));
    }

    public void update(CarDto carDto){
        var car = carRepository.findById(carDto.getId()).orElse(null);
        if(car != null){
            car.setMake(carDto.getMake());
            car.setModel(carDto.getModel());
            car.setPyear(carDto.getPyear());
            carRepository.save(car);
        }
    }

    public void delete(int carId){
        carRepository.findById(carId).ifPresent(car -> carRepository.deleteById(carId));
    }

}