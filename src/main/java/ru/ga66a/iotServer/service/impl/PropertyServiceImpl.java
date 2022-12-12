package ru.ga66a.iotServer.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.ga66a.iotServer.domain.Property;
import ru.ga66a.iotServer.repository.PropertyRepository;
import ru.ga66a.iotServer.service.PropertyService;
import ru.ga66a.iotServer.service.exception.PropertyServiceException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final Environment environment;

    @Override
    public Property get(String name) {
        Optional<Property> propertyOptional = propertyRepository.findById(name);
        if (propertyOptional.isEmpty()) {
            Property property = environment.getProperty(name, Property.class);
            if (property == null) {
                throw new PropertyServiceException(String.format("Property \"%s\" not found.", name));
            } else {
                save(property);
                return property;
            }
        } else {
            return propertyOptional.get();
        }
    }
    @Override
    public Property save(Property property) {
        return propertyRepository.save(property);
    }
}
