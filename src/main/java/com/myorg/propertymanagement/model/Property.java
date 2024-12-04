package com.myorg.propertymanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myorg.propertymanagement.dto.CreatePropertyDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String street;
    private  String city;
    private String description;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    @JsonIgnore
    private Manager manager;

    public Property(CreatePropertyDTO dto, Manager manager) {
        this.street = dto.getStreet();
        this.city = dto.getCity();
        this.description = dto.getDescription();
        this.manager = manager;
    }


}
