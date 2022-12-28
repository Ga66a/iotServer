package ru.ga66a.iotServer.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(IndicatorId.class)
public class Indicator {
    @Id
    @Column(name = "device_mac")
    private String deviceMac;

    @Id
    private String name;

    private Integer pin;

    private String type;

    private Integer currentState;

    @Column(insertable = false, updatable = false)
    private Integer targetState;

    private Float indication;

    private Date lastSeen;
}
