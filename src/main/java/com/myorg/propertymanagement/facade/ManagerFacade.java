package com.myorg.propertymanagement.facade;

import com.myorg.propertymanagement.dto.ManagerDTO;
import com.myorg.propertymanagement.model.Manager;
import com.myorg.propertymanagement.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ManagerFacade {

    @Autowired
    ManagerService managerService;

    public ResponseEntity<Object> handleSignup(ManagerDTO body) {
        Map<String, Object> response = new HashMap<>();
        try {
            Manager newManager = managerService.createManager(body);
            response.put("message", "Manager Added Successfully");
            response.put("data", newManager);
            response.put("success", true);
            return ResponseEntity.ok(response);
        } catch (DataIntegrityViolationException e) {
            response.put("message", "Email already registered");
            response.put("success", false);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }

    public ResponseEntity<Object> handleLogin(ManagerDTO body) {
        Map<String, Object> response = new HashMap<>();
        try {
            String token = managerService.login(body);
            response.put("token", token);
            response.put("message", "Login Successful");
            response.put("success", true);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("message", "Invalid email or password");
            response.put("success", false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}

