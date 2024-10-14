package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {
    public PropertyDTO saveProperty (PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDto, Long propertId);

    public PropertyDTO updatePropertyDescription( PropertyDTO propertyDTO,  Long propertyId);
    public PropertyDTO updatePropertyPrice( PropertyDTO propertyDTO, Long propertyId) ;

    void deleteProperty(Long propertyId);
}
