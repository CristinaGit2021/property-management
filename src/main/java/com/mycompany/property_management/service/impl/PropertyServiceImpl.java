package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = propertyConverter.convertDtoToEntity(propertyDTO);
        propertyEntity = propertyRepository.save(propertyEntity);
        return propertyConverter.convertEntityToDto(propertyEntity);
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        System.out.println("Testing git");
        List<PropertyEntity> listProps =   (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();
        for(PropertyEntity propertyEntity : listProps) {
            PropertyDTO dto= propertyConverter.convertEntityToDto(propertyEntity);
            propList.add(dto);
        }
        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        PropertyDTO dto = null;
      Optional<PropertyEntity> optEn= propertyRepository.findById(propertyId);
      if(optEn.isPresent()) {
          PropertyEntity propertyEntity = optEn.get();
          propertyEntity.setTitle(propertyDTO.getTitle());
          propertyEntity.setAddress(propertyDTO.getAddress());
          propertyEntity.setDescription(propertyDTO.getDescription());
          propertyEntity.setPrice(propertyDTO.getPrice());
          dto= propertyConverter.convertEntityToDto(propertyEntity);
          propertyRepository.save(propertyEntity);
      }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        PropertyDTO dto = null;
        Optional<PropertyEntity> optEn= propertyRepository.findById(propertyId);
        if(optEn.isPresent()) {
            PropertyEntity propertyEntity = optEn.get();
            propertyEntity.setDescription(propertyDTO.getDescription());
            dto= propertyConverter.convertEntityToDto(propertyEntity);
            propertyRepository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        PropertyDTO dto = null;
        Optional<PropertyEntity> optEn= propertyRepository.findById(propertyId);
        if(optEn.isPresent()) {
            PropertyEntity propertyEntity = optEn.get();
            propertyEntity.setPrice(propertyDTO.getPrice());
            dto= propertyConverter.convertEntityToDto(propertyEntity);
            propertyRepository.save(propertyEntity);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
