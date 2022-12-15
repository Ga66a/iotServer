package ru.ga66a.iotServer.domain;

import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class IndicatorId implements Serializable {
    private  String deviceMak;
    private  String name;

    public IndicatorId(String deviceMak, String name) {
        this.deviceMak = deviceMak;
        this.name = name;
    }

}
