package ru.ga66a.iotServer.service;

import ru.ga66a.iotServer.domain.Device;

import java.util.Optional;

public interface DeviceService {
    Device get(String id);

    Device create(String id);
}
