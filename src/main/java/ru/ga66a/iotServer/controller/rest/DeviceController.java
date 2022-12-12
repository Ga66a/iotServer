package ru.ga66a.iotServer.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ga66a.iotServer.domain.Device;
import ru.ga66a.iotServer.service.DeviceService;

@RestController
@RequestMapping("/api/v1/device")
@AllArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping("/{id}")
    public Device getDevice(@PathVariable("id") String id) {
        return deviceService.get(id);
    }
}
