package ru.ga66a.iotServer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ga66a.iotServer.domain.Device;
import ru.ga66a.iotServer.domain.Indicator;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {
    private String mak;
    private List<IndicatorDto> indicators;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class IndicatorDto {
        private String name;
        private String type;
        private Integer currentState;
    }

    public static Device toDomain(DeviceDto deviceDto) {
        Device device = new Device(deviceDto.getMak());
        for (IndicatorDto indicatorDto : deviceDto.getIndicators()) {
            Indicator indicator = new Indicator();
            indicator.setDeviceMak(deviceDto.getMak());
            indicator.setName(indicatorDto.getName());
            indicator.setCurrentState(indicatorDto.getCurrentState());
            indicator.setType(indicatorDto.getType());
            device.getIndicators().add(indicator);
        }
        return device;
    }

    public static DeviceDto toDto(Device device) {
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setMak(device.getMak());
        for (Indicator indicator : device.getIndicators()) {
            deviceDto.getIndicators().add(new IndicatorDto(indicator.getName(), indicator.getType(), indicator.getCurrentState()));
        }
        return deviceDto;
    }


}
