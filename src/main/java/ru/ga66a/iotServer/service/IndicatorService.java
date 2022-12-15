package ru.ga66a.iotServer.service;

import ru.ga66a.iotServer.domain.Indicator;
import ru.ga66a.iotServer.domain.IndicatorTargetState;

import java.util.List;

public interface IndicatorService {
    void setIndicatorTargetState(Indicator indicator, Integer state);

    List<IndicatorTargetState> getIndicatorsToChange(String deviceMak);
}
