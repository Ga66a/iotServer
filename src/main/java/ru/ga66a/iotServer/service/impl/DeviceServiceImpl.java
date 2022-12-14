package ru.ga66a.iotServer.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ga66a.iotServer.domain.Device;
import ru.ga66a.iotServer.domain.dto.DeviceDto;
import ru.ga66a.iotServer.repository.DeviceRepository;
import ru.ga66a.iotServer.service.DeviceService;

@AllArgsConstructor
@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    @Override
    public Device get(String mak) {
        return deviceRepository.findById(mak).orElseGet(() -> create(mak));
//        if (deviceRepository.existsById(id))
//            return deviceRepository.findById(id).get();
//        else
//            return create(id);
//        if (deviceOptional.isEmpty()){
//            return create(id);
//        }else {
//            return deviceOptional.get();
//        }
        //return device;
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
        return save(DeviceDto.toDomain(deviceDto));
    }
}
