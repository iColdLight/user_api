package com.coldlight.user_api.config;

import io.r2dbc.spi.ConnectionFactory;
import org.flywaydb.core.internal.resource.classpath.ClassPathResource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

//@TestConfiguration
public class TestDatabaseConfiguration {

    //@Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);

        /*CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
        populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("V2__test_tables.sql")));
        initializer.setDatabasePopulator(populator);*/

        return initializer;
    }

}
