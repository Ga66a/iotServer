package ru.ga66a.iotServer.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(OutputId.class)
public class Output {
    @Id
    @Column(name = "device_mak")
    private String deviceMak;
    @Id
    private Integer outputNumber;
    private String description;
    private Integer currentState;
    private Integer targetState;
    private Boolean readOnly;
}
