package ru.ga66a.iotServer.service;

import ru.ga66a.iotServer.domain.dto.DeviceDto;
import ru.ga66a.iotServer.domain.Device;

public interface DeviceService {
    Device get(String id);

    Device create(String id);

    Device save(Device device);

    Device save(DeviceDto deviceDto);
}
