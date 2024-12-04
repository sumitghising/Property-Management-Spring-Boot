package com.myorg.propertymanagement.service;

import com.myorg.propertymanagement.dto.CreatePropertyDTO;
import com.myorg.propertymanagement.dto.DeletePropertyDTO;
import com.myorg.propertymanagement.dto.UpdatePropertyDTO;
import com.myorg.propertymanagement.model.Manager;
import com.myorg.propertymanagement.model.Property;
import com.myorg.propertymanagement.repository.ManagerRepository;
import com.myorg.propertymanagement.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    ManagerRepository managerRepository;

    public Long verifyTokenAndGetId(String token){

        if(ManagerService.loggedInUsers.containsKey(token)) {
            return ManagerService.loggedInUsers.get(token);
        }
        return null;
        }
    public Property addProperty(CreatePropertyDTO dto){
    Long managerId = verifyTokenAndGetId(dto.getToken());
    if(managerId == null){
        throw new IllegalArgumentException();
    }
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(() -> new IllegalArgumentException("Manager not found with ID: " + managerId));

    return this.propertyRepository.save(new Property(dto, manager));

    }
    public String deleteProperty(DeletePropertyDTO dto){
        Long managerId = verifyTokenAndGetId(dto.getToken());
        Property property = this.propertyRepository.findByIdAndManagerId(dto.getPropertyId(), managerId);
        if(managerId == null || property == null){
            throw new IllegalArgumentException();
        }
        this.propertyRepository.deleteById(property.getId());
        return "Deleted Successfully";
    }

    public Property updateProperty(UpdatePropertyDTO dto){
        Long managerId = verifyTokenAndGetId(dto.getToken());
        Property property = this.propertyRepository.findByIdAndManagerId(dto.getPropertyId(), managerId);

        if(managerId == null || property == null){
            throw new IllegalArgumentException();
        }
        property.setCity(dto.getCity());
        property.setDescription(dto.getDescription());
        property.setStreet(dto.getStreet());
        return  this.propertyRepository.save(property);
    }

    public List<Property> listProperties(String token){
        Long managerId = verifyTokenAndGetId(token);
        if(managerId == null){
            throw new IllegalArgumentException();
        }

        return this.propertyRepository.findAllByManagerId(managerId);

    }
}
