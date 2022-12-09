package ru.ga66a.iotServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ga66a.iotServer.domain.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {
}
