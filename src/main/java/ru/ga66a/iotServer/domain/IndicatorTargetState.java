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
    @Column(name = "device_mak")
    private String deviceMak;

    @Id
    private String name;

    private Integer targetState;

    @Column(insertable = false, updatable = false)
    private Integer currentState;
}
