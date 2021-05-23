package com.techlake.cloud.reactive;


import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
@Component
public class DeviceRouterFactory {

    @Bean
    public RouterFunction<ServerResponse> route(DeviceHandler deviceHandler) {
        return RouterFunctions.route(
                GET("/device/all")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                serverRequest -> deviceHandler.getAllDevices(serverRequest)
        ).andRoute(PUT("/device/save")
                .and(accept(MediaType.APPLICATION_JSON)),
                serverRequest -> deviceHandler.saveDevice(serverRequest));
    }


}
