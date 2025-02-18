package com.myorg.propertymanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myorg.propertymanagement.dto.ManagerDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "manager", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
@NoArgsConstructor

public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @OneToMany(mappedBy = "manager")
    @JsonIgnore
    private List<Property> properties;


    public Manager(ManagerDTO dto){
        this.email = dto.getEmail();
        this.password = dto.getPassword();
    }
    @Override
    public String toString() {
        return "Manager{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
