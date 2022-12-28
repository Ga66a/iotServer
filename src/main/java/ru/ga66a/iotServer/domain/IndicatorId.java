package ru.ga66a.iotServer.domain;

import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class IndicatorId implements Serializable {
    private  String deviceMac;
    private  String name;

    public IndicatorId(String deviceMac, String name) {
        this.deviceMac = deviceMac;
        this.name = name;
    }

}
