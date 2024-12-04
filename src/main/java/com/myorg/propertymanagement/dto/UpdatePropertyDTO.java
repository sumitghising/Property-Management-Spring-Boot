package com.myorg.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdatePropertyDTO {
    private String token;
    private Long propertyId;
    private  String street;
    private String city;
    private String description;
}
