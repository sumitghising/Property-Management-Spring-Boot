package com.myorg.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeletePropertyDTO {
    private String token;
    private long propertyId;
}
