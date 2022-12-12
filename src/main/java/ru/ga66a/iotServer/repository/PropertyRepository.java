package ru.ga66a.iotServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ga66a.iotServer.domain.Property;

public interface PropertyRepository extends JpaRepository<Property, String> {
}
