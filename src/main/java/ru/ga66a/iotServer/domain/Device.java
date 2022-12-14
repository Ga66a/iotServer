package ru.ga66a.iotServer.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    public Device(String mak) {
        this.mak = mak;
    }

    @Id
    private String mak;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "device_mak")
    private List<Output> outputs;
}
