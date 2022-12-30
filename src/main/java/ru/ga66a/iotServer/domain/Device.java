package ru.ga66a.iotServer.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable(false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    public Device(String mac) {
        this.mac = mac;
        this.indicators = new ArrayList<>();
    }

    @Id
    private String mac;
    private String firmwareUrlCurrent;
    @Column(insertable = false, updatable = false)
    private String firmwareUrlTarget;
    private Boolean deepSleep;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "device_mac")
    private List<Indicator> indicators;
}
