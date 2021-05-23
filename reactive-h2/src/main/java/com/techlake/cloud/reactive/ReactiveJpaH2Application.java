package com.techlake.cloud.reactive;

import io.r2dbc.spi.ConnectionFactory;
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
        final String sql = "drop table IF EXISTS DEVICE;\n" +
                "CREATE TABLE IF NOT EXISTS DEVICE ( id serial primary key, type varchar(255) not null , name varchar(255) not null );";

        return args -> {
            databaseClient.sql(sql)
                    .fetch()
                    .rowsUpdated()
                    .thenMany(Flux.just(new Device(null,"DP1","DP One"),
                            new Device(null,"DP2","DP Two")))
                    .flatMap(deviceRepository::save)
                    .thenMany(deviceRepository.findAll())
                    .subscribe(device -> System.out.println(device.toString()));

        };
    }
}
