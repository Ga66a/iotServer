package ru.ga66a.iotServer.service;

import org.springframework.stereotype.Service;
import ru.ga66a.iotServer.domain.Device;

@Service
public interface OpenTSDBService {
    void put(Device device);
}
