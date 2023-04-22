package com.example.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CarDto {
    private Integer id;
    private String make;
    private String model;
    private Integer pyear;
}
