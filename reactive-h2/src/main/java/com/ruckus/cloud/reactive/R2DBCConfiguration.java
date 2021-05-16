package com.ruckus.cloud.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import io.r2dbc.h2.H2ConnectionFactory;

@Configuration
@EnableR2dbcRepositories
public class R2DBCConfiguration extends AbstractR2dbcConfiguration {

    @Override
    @Bean
    public H2ConnectionFactory connectionFactory() {
        return new H2ConnectionFactory(
                io.r2dbc.h2.H2ConnectionConfiguration.builder()
                        .url("r2dbc:h2:mem://DEVICE;DB_CLOSE_DELAY=-1;")
                        .build()
        );
    }
}
