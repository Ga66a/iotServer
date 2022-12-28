package ru.ga66a.iotServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ga66a.iotServer.domain.IndicatorId;
import ru.ga66a.iotServer.domain.IndicatorTargetState;

import java.util.List;

@Repository
public interface IndicatorTargetStateRepository extends JpaRepository<IndicatorTargetState, IndicatorId> {
    List<IndicatorTargetState> findByDeviceMac(String deviceMac);
}
