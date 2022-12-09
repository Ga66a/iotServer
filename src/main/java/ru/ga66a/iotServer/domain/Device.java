package ru.ga66a.iotServer.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="device")
@AllArgsConstructor

public class Device {
    @Id
    private final String id;

}
