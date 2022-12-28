package ru.ga66a.iotServer.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ga66a.iotServer.domain.IndicatorTargetState;
import ru.ga66a.iotServer.domain.dto.DeviceDto;
import ru.ga66a.iotServer.service.DeviceService;
import ru.ga66a.iotServer.service.IndicatorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/iot/device")
@AllArgsConstructor
public class DeviceControllerIOT {
    private final DeviceService deviceService;

    private final IndicatorService indicatorService;

    @GetMapping("/{deviceMac}")
    public List<IndicatorTargetState> getDevice(@PathVariable("deviceMac") String deviceMac) {
        return indicatorService.getIndicatorsToChange(deviceMac);
    }
    @PostMapping("/")
    public void saveDevice(@RequestBody DeviceDto deviceDto){
         deviceService.save(deviceDto);
    }

}
