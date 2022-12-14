package ru.ga66a.iotServer.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ga66a.iotServer.domain.dto.DeviceDto;
import ru.ga66a.iotServer.service.DeviceService;

@RestController
@RequestMapping("/api/v1/device")
@AllArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping("/{mak}")
    public DeviceDto getDevice(@PathVariable("mak") String mak) {
        return DeviceDto.toDto(deviceService.get(mak));
    }
    @PostMapping("/")
    public void saveDevice(@RequestBody DeviceDto deviceDto){

         deviceService.save(deviceDto);
    }

}
