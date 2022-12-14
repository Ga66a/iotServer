package ru.ga66a.iotServer.domain;

import java.io.Serializable;

public class OutputId implements Serializable {
    private final String deviceMak;
    private final Integer outputNumber;

    public OutputId(String deviceMak, Integer outputNumber) {
        this.deviceMak = deviceMak;
        this.outputNumber = outputNumber;
    }

}
