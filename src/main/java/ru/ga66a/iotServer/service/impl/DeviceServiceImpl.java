package ru.ga66a.iotServer.service.impl;

import lombok.AllArgsConstructor;
import ru.ga66a.iotServer.domain.Device;
import ru.ga66a.iotServer.repository.DeviceRepository;
import ru.ga66a.iotServer.service.DeviceService;

@AllArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    @Override
    public Device get(String id) {
        return deviceRepository.findById(id).orElse(create(id));
    }

    @Override
    public Device create(String id) {
        Device device = new Device(id);
        deviceRepository.save(device);
        return device;
    }
}
