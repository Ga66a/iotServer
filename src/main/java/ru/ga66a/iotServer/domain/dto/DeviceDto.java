package ru.ga66a.iotServer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ga66a.iotServer.domain.Device;
import ru.ga66a.iotServer.domain.Output;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {
    private String mak;
    private List<OutputDto> outputs;

    @Getter
    @AllArgsConstructor
    private static class OutputDto {
        private Boolean readOnly;
        private Integer outputNumber;
    }

    public static Device toDomain(DeviceDto deviceDto) {
        Device device = new Device(deviceDto.getMak());
        for (OutputDto outputDto : deviceDto.getOutputs()) {
            Output output = new Output();
            output.setOutputNumber(outputDto.getOutputNumber());
            output.setReadOnly(outputDto.getReadOnly());
            device.getOutputs().add(output);
        }
        return device;
    }

    public static DeviceDto toDto(Device device) {
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setMak(device.getMak());
        for (Output output : device.getOutputs()) {
            deviceDto.getOutputs().add(new OutputDto(output.getReadOnly(),output.getOutputNumber()) );
        }
        return deviceDto;
    }


}
