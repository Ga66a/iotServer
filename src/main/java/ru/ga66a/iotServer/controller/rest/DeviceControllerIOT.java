package ru.ga66a.iotServer.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ga66a.iotServer.domain.IndicatorTargetState;
import ru.ga66a.iotServer.domain.dto.DeviceDto;
import ru.ga66a.iotServer.service.DeviceService;
import ru.ga66a.iotServer.service.IndicatorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/device/iot")
@AllArgsConstructor
public class DeviceControllerIOT {
    private final DeviceService deviceService;

    private final IndicatorService indicatorService;

    @GetMapping("/{deviceMak}")
    public List<IndicatorTargetState> getDevice(@PathVariable("deviceMak") String deviceMak) {
        return indicatorService.getIndicatorsToChange(deviceMak);
    }
    @PostMapping("/")
    public void saveDevice(@RequestBody DeviceDto deviceDto){
         deviceService.save(deviceDto);
    }

}
