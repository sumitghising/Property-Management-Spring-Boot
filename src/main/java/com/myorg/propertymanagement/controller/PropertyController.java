package com.myorg.propertymanagement.controller;

import com.myorg.propertymanagement.dto.CreatePropertyDTO;
import com.myorg.propertymanagement.dto.DeletePropertyDTO;
import com.myorg.propertymanagement.dto.UpdatePropertyDTO;
import com.myorg.propertymanagement.model.Property;
import com.myorg.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("property")
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @PostMapping("/")
    public ResponseEntity<Object> addProperty(@RequestBody CreatePropertyDTO body){
        Map<String, Object> response = new HashMap<>();
        try {
            Property newProperty = this.propertyService.addProperty(body);
            response.put("message", "Property Added Successfully");

            response.put("success", true);
            response.put("property", newProperty);

            return ResponseEntity.ok(response);

        }catch (IllegalArgumentException e){
            response.put("success", false);
            response.put("message", "You are not logged in");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

        }

    }
    @DeleteMapping("/")
    public ResponseEntity<Object> deleteProperty(@RequestBody DeletePropertyDTO body){
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("message", this.propertyService.deleteProperty(body));
            response.put("success", true);
            return ResponseEntity.ok(response);

        }
        catch(IllegalArgumentException e){
            response.put("success", false);
            response.put("message", "Access Denied");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);


        }

    }

    @PutMapping("/")
    public ResponseEntity<Object> updateProperty(@RequestBody UpdatePropertyDTO body){
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("message", "Property Updated Successfully");
            response.put("success", true);
            response.put("property", this.propertyService.updateProperty(body));

            return ResponseEntity.ok(response);

        }
        catch(IllegalArgumentException e){
            response.put("success", false);
            response.put("message", "Access Denied");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

        }

    }
    @GetMapping("/{token}")
    public ResponseEntity<Object> listProperties(@PathVariable String token){
        Map<String, Object> response = new HashMap<>();
        try {

            response.put("success", true);
            response.put("propertiesYouManage", this.propertyService.listProperties(token));

            return ResponseEntity.ok(response);

        }catch (IllegalArgumentException e){
            response.put("success", false);
            response.put("message", "You are not logged in");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

        }

    }

    }
