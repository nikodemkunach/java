package com.example.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String make;
    private String model;
    private Integer pyear;

    public Car(Integer id, String make, String model, Integer pyear) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.pyear = pyear;
    }

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
