package ru.ga66a.iotServer.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ga66a.iotServer.domain.Device;
import ru.ga66a.iotServer.domain.dto.DeviceDto;
import ru.ga66a.iotServer.repository.DeviceRepository;
import ru.ga66a.iotServer.service.DeviceService;
import ru.ga66a.iotServer.service.OpenTSDBService;

@AllArgsConstructor
@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;
    private final OpenTSDBService openTSDBService;
    @Override
    public Device get(String mak) {
        return deviceRepository.findById(mak).orElseGet(() -> create(mak));
    }

    @Override
    public Device create(String mak) {
        return deviceRepository.save(new Device(mak));
    }

    @Override
    @Transactional
    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device save(DeviceDto deviceDto) {
        Device device = DeviceDto.toDomain(deviceDto);
        openTSDBService.put(device);
        return save(device);
    }
}
