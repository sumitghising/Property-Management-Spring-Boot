package com.myorg.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePropertyDTO {
    private  String street;
    private String city;
    private String description;
    private String token;

}
