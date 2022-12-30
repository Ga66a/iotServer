package ru.ga66a.iotServer.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ga66a.iotServer.domain.Device;
import ru.ga66a.iotServer.domain.dto.DeviceDto;
import ru.ga66a.iotServer.repository.DeviceRepository;
import ru.ga66a.iotServer.service.DeviceService;
import ru.ga66a.iotServer.service.OpenTSDBService;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Service
public class DeviceServiceImpl implements DeviceService {
    @PersistenceContext
    private EntityManager entityManager;
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
    @Transactional
    public Device save(DeviceDto deviceDto) {
        Device device = DeviceDto.toDomain(deviceDto);
        openTSDBService.put(device);
        return save(device);
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, String> getDeviceParameters(String mac) {
        entityManager.flush();
        entityManager.clear();
        Device device = deviceRepository.findById(mac).orElse(null);
        Map<String, String> kvMap = new HashMap<>();
        if (device != null) {
            if (device.getDeepSleep() != null) {
                kvMap.put("deepSleep", device.getDeepSleep().toString());
            }
            if (!device.getFirmwareUrlCurrent().equalsIgnoreCase(device.getFirmwareUrlTarget()) && device.getFirmwareUrlTarget() != null) {
                kvMap.put("upgrade", device.getFirmwareUrlTarget());
            }
        }
        return kvMap;
    }
}
