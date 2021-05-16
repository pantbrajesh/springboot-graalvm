package com.ruckus.cloud.reactive;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DeviceRepository extends ReactiveCrudRepository<Device, Integer> {
}
