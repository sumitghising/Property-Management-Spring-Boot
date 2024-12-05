package com.myorg.propertymanagement.service;


import com.myorg.propertymanagement.dto.CreatePropertyDTO;
import com.myorg.propertymanagement.dto.DeletePropertyDTO;
import com.myorg.propertymanagement.dto.UpdatePropertyDTO;
import com.myorg.propertymanagement.model.Property;

import java.util.List;

public interface PropertyService {
    Property addProperty(CreatePropertyDTO propertyDto);
    String deleteProperty(DeletePropertyDTO propertyDto);
    Property updateProperty(UpdatePropertyDTO propertyDto);
    List<Property> listProperties(String token);
}
