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
    private String mac;
    private String firmwareUrlCurrent;
    private List<IndicatorDto> indicators;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class IndicatorDto {
        private String name;
        private String type;
        private Integer pin;
        private Integer currentState;
        private Float indication;
    }

    public static Device toDomain(DeviceDto deviceDto) {
        Device device = new Device(deviceDto.getMac());
        device.setFirmwareUrlCurrent(deviceDto.getFirmwareUrlCurrent());
        for (IndicatorDto indicatorDto : deviceDto.getIndicators()) {
            Indicator indicator = new Indicator();
            indicator.setDeviceMac(deviceDto.getMac());
            indicator.setName(indicatorDto.getName());
            indicator.setPin(indicatorDto.getPin());
            indicator.setCurrentState(indicatorDto.getCurrentState());
            indicator.setType(indicatorDto.getType());
            indicator.setIndication(indicatorDto.getIndication());
            device.getIndicators().add(indicator);
        }
        return device;
    }

    public static DeviceDto toDto(Device device) {
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setMac(device.getMac());

        deviceDto.setFirmwareUrlCurrent(device.getFirmwareUrlCurrent());
        for (Indicator indicator : device.getIndicators()) {
            deviceDto.getIndicators().add(new IndicatorDto(
                    indicator.getName(),
                    indicator.getType(),
                    indicator.getPin(),
                    indicator.getCurrentState(),
                    indicator.getIndication()));
        }
        return deviceDto;
    }


}
