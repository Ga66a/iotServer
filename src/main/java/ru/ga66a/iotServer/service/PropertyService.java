package ru.ga66a.iotServer.service;

import ru.ga66a.iotServer.domain.Property;

public interface PropertyService {
    Property get(String name);
    Property save(Property property);
}
