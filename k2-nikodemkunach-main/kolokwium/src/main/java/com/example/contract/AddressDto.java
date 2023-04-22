package com.example.contract;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AddressDto {
    private Integer id;
    private String city;
    @JsonProperty("postal_code")
    private String postalCode;
    private String street;

}
