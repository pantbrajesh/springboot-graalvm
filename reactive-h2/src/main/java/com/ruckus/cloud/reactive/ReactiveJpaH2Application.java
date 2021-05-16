package com.ruckus.cloud.reactive;

import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactiveJpaH2Application {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveJpaH2Application.class, args);
    }


    @Bean
    ApplicationRunner runner(DatabaseClient databaseClient, DeviceRepository deviceRepository, ConnectionFactory connectionFactory) {


        return args -> {

            Flux<Device> devices = Flux
                    .just(new Device(null,"DP1","DP One"),
                            new Device(null,"DP2","DP Two"))
                    .flatMap(deviceRepository::save);

            DatabaseClient.create(connectionFactory)
                    .sql("create table DEVICE ( id serial primary key, " +
                            " type varchar(255) not null , " +
                            " name varchar(255) not null)")
                    .fetch()
                    .rowsUpdated().thenMany(devices).thenMany(deviceRepository.findAll()).subscribe(device -> System.out.println(device.toString()));


        };
    }
}
