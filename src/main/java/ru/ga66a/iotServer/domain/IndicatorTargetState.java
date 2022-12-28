package ru.ga66a.iotServer.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "indicator")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(IndicatorId.class)
public class IndicatorTargetState {
    @Id
    @Column(name = "device_mac")
    private String deviceMac;

    @Id
    private String name;

    private Integer targetState;

    private Integer pin;

    @Column(insertable = false, updatable = false)
    private Integer currentState;
}
