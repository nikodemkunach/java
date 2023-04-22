package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MyRestController {
    private MyRestService restService;

    @Autowired
    public MyRestController(MyRestService restService) {
        this.restService = restService;
    }

    @GetMapping("animals")
    public List<Animal> returnAnimals() {
        return restService.getList();
    }

    @DeleteMapping("animals/delete/{id}")
    public void deleteAnimals(@PathVariable int id) {
        restService.deleteFromList(id);
    }

    @PostMapping("animals/add")
    public void addToList(@RequestBody Animal animal) {
        restService.addToList(animal);
    }

    @GetMapping("animals/{id}")
    public Animal getAnimalByID(@PathVariable int id){
        return restService.getAnimalByID(id);
    }
}