package ru.ga66a.iotServer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ga66a.iotServer.domain.Indicator;
import ru.ga66a.iotServer.domain.IndicatorId;
import ru.ga66a.iotServer.domain.IndicatorTargetState;
import ru.ga66a.iotServer.repository.IndicatorTargetStateRepository;
import ru.ga66a.iotServer.service.IndicatorService;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class IndicatorServiceImpl implements IndicatorService {
    private final IndicatorTargetStateRepository indicatorTargetStateRepository;

    @Override
    public void setIndicatorTargetState(Indicator indicator, Integer state) {
        IndicatorTargetState indicatorTargetState = indicatorTargetStateRepository
                .findById(new IndicatorId(indicator.getDeviceMac(), indicator.getName()))
                .orElseThrow(() ->
                        new IllegalStateException(String.format("Indicator not found. MAC: %s Name:%s",
                                indicator.getDeviceMac(), indicator.getName())));
        indicatorTargetState.setTargetState(state);
        indicatorTargetStateRepository.save(indicatorTargetState);
    }

    @Override
    public List<IndicatorTargetState> getIndicatorsToChange(String deviceMac) {
        List<IndicatorTargetState> indicatorsTargetStates = indicatorTargetStateRepository.findByDeviceMac(deviceMac);
        indicatorsTargetStates.removeIf(
                indicator ->
                        indicator.getTargetState() == null || Objects.equals(indicator.getTargetState(), indicator.getCurrentState()));
        return indicatorsTargetStates;
    }
}
