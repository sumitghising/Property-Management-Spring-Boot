package com.myorg.propertymanagement.service;


import com.myorg.propertymanagement.dto.CreatePropertyDTO;

import com.myorg.propertymanagement.dto.DeletePropertyDTO;

import com.myorg.propertymanagement.dto.ManagerDTO;
import com.myorg.propertymanagement.dto.UpdatePropertyDTO;

import com.myorg.propertymanagement.model.Manager;
import com.myorg.propertymanagement.model.Property;

import java.util.List;

public interface ManagerService {
    Manager createManager(ManagerDTO dto);
    String login(ManagerDTO manager);
    String randomStringGenerator();
}

