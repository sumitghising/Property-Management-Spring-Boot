package com.myorg.propertymanagement.facade;

import com.myorg.propertymanagement.dto.CreatePropertyDTO;
import com.myorg.propertymanagement.dto.DeletePropertyDTO;
import com.myorg.propertymanagement.dto.UpdatePropertyDTO;
import com.myorg.propertymanagement.model.Property;
import com.myorg.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class PropertyFacade {

    @Autowired
    private PropertyService propertyService;

    public ResponseEntity<Object> handleAddProperty(CreatePropertyDTO body) {
        Map<String, Object> response = new HashMap<>();
        try {
            Property newProperty = propertyService.addProperty(body);
            response.put("message", "Property Added Successfully");
            response.put("success", true);
            response.put("property", newProperty);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("success", false);
            response.put("message", "You are not logged in");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    public ResponseEntity<Object> handleDeleteProperty(DeletePropertyDTO body) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("message", propertyService.deleteProperty(body));
            response.put("success", true);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("success", false);
            response.put("message", "Access Denied");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    public ResponseEntity<Object> handleUpdateProperty(UpdatePropertyDTO body) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("message", "Property Updated Successfully");
            response.put("success", true);
            response.put("property", propertyService.updateProperty(body));
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("success", false);
            response.put("message", "Access Denied");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    public ResponseEntity<Object> handleListProperties(String token) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("success", true);
            response.put("propertiesYouManage", propertyService.listProperties(token));
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("success", false);
            response.put("message", "You are not logged in");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}

