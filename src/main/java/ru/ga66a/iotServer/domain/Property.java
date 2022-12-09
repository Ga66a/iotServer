package ru.ga66a.iotServer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Property {
    @Id
    private String key;
    private String value;
}
