package com.myorg.propertymanagement.controller;

import com.myorg.propertymanagement.dto.CreatePropertyDTO;
import com.myorg.propertymanagement.dto.DeletePropertyDTO;
import com.myorg.propertymanagement.dto.UpdatePropertyDTO;
import com.myorg.propertymanagement.facade.PropertyFacade ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("property")
public class PropertyController {

    @Autowired
    private PropertyFacade propertyFacade;

    @PostMapping("/")
    public ResponseEntity<Object> addProperty(@RequestBody CreatePropertyDTO body) {
        return propertyFacade.handleAddProperty(body);
    }

    @DeleteMapping("/")
    public ResponseEntity<Object> deleteProperty(@RequestBody DeletePropertyDTO body) {
        return propertyFacade.handleDeleteProperty(body);
    }

    @PutMapping("/")
    public ResponseEntity<Object> updateProperty(@RequestBody UpdatePropertyDTO body) {
        return propertyFacade.handleUpdateProperty(body);
    }

    @GetMapping("/{token}")
    public ResponseEntity<Object> listProperties(@PathVariable String token) {
        return propertyFacade.handleListProperties(token);
    }
}

