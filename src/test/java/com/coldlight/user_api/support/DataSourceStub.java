package com.coldlight.user_api.support;

import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@TestConfiguration
public class DataSourceStub {
    private static final String CLEAN_FORMAT = "DROP SCHEMA IF EXISTS %s CASCADE; CREATE SCHEMA %s;";
    private static final String CLEAN_PUBLIC = "DROP SCHEMA IF EXISTS public CASCADE; CREATE SCHEMA public;";
    private static final String SELECT_FORMAT = "ALTER USER %s SET search_path to %s;";

    private final static PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>("postgres:10")
            .withDatabaseName("person")
            .withCommand("postgres -c max_connections=300");

    static {
        POSTGRES.start();
    }

    @Value("${spring.r2dbc.properties.hibernate.default_schema}")
    private String schema;

    @Value("${spring.flyway.table}")
    private String table;

    @Value("${spring.flyway.schemas}")
    private String schemas;

    @Primary
    @Bean
    public DataSource dataSource() throws SQLException {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setUser(POSTGRES.getUsername());
        ds.setPassword(POSTGRES.getPassword());
        ds.setUrl(POSTGRES.getJdbcUrl());

        try (Connection connection = ds.getConnection()) {
            connection.prepareStatement(CLEAN_PUBLIC).execute();
            connection.prepareStatement(String.format(CLEAN_FORMAT, schema, schema)).execute();
            connection.prepareStatement(String.format(SELECT_FORMAT, POSTGRES.getUsername(), schema)).execute();
        }

        Flyway.configure()
                .dataSource(ds)
                .schemas(schemas)
                .table(table)
                .load()
                .migrate();

        return ds;
    }

    /*@Primary
    @Bean
    public ConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration configuration = PostgresqlConnectionConfiguration.builder()
                .host(POSTGRES.getHost())
                .port(POSTGRES.getMappedPort(PostgreSQLContainer.POSTGRESQL_PORT))
                .database(POSTGRES.getDatabaseName())
                .username(POSTGRES.getUsername())
                .password(POSTGRES.getPassword())
                .build();

        PostgresqlConnectionFactory connectionFactory = new PostgresqlConnectionFactory(configuration);

        try {
            cleanAndMigrateDatabase(connectionFactory).block();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize test database.", e);
        }

        return connectionFactory;
    }

    private Mono<Void> cleanAndMigrateDatabase(ConnectionFactory connectionFactory) {
        Flyway flyway = Flyway.configure()
                .dataSource((DataSource) connectionFactory)
                .schemas(schemas)
                .table(table)
                .load();

        Mono<Void> migrationMono = Mono.from(flyway.migrate())
                .thenEmpty();

        return Mono.from(connectionFactory.create())
                .flatMapMany(connection -> {
                    Mono<Void> cleanPublicSchemaMono = connection.createStatement(CLEAN_PUBLIC)
                            .execute()
                            .then();

                    Mono<Void> cleanFormatSchemaMono = connection.createStatement(String.format(CLEAN_FORMAT, schema, schema))
                            .execute()
                            .then();

                    Mono<Void> selectFormatMono = connection.createStatement(String.format(SELECT_FORMAT, POSTGRES.getUsername(), schema))
                            .execute()
                            .then();

                    return Mono.when(cleanPublicSchemaMono, cleanFormatSchemaMono, selectFormatMono)
                            .thenEmpty()
                            .doFinally(signalType -> connection.close());
                })
                .then(migrationMono);
    }*/
}
