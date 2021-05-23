package com.techlake.cloud.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Component
public class DeviceHandler {

    @Autowired
    private DeviceRepository deviceRepository;

    public Mono<ServerResponse> getAllDevices(ServerRequest serverRequest) {

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(deviceRepository.findAll(),Device.class));
    }

    public Mono<ServerResponse> saveDevice(ServerRequest serverRequest) {

        final Mono<Device> deviceMono = serverRequest.bodyToMono(Device.class);
        return  ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(
                        deviceMono.map(p -> new Device(p.getId(), p.getType(),p.getName()))
                                .flatMap(deviceRepository::save), Device.class));

    }

    private Flux<Device> getAllDevices(){
        return deviceRepository.findAll();
    }

    private Mono<Device> saveDevice(Device device){
        return deviceRepository.save(device);
    }
}
