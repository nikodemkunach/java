package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MyRestService{
        Animal animal1 = new Animal(4,12,"Azor","Dog",1);
        Animal animal2 = new Animal(4,11,"Freja","Cat",2);
        Animal animal3 = new Animal(4,27,"Łucja","Elephant",3);
        private List<Animal> myList = new ArrayList<>(Arrays.asList(animal3,animal2,animal1));

        public List<Animal> getList(){
            return myList;
        }

        public void deleteFromList(int id){
            myList.remove(myList.get(id));
        }

        public void addToList(Animal animal){
            myList.add(animal);
        }

    public Animal getAnimalByID(int id){
           return myList.get(id);
    }
}

