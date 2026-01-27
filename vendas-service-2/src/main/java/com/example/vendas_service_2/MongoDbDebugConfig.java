package com.example.vendas_service_2;

import com.mongodb.ConnectionString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Slf4j
@Configuration
public class MongoDbDebugConfig {

    @Value("${spring.data.mongodb.uri:}")
    private String mongoUri;

    @Value("${spring.data.mongodb.host:}")
    private String host;

    @Value("${spring.data.mongodb.port:}")
    private String port;

    @Value("${spring.data.mongodb.database:}")
    private String database;

    @Value("${spring.data.mongodb.username:}")
    private String username;

    @Value("${spring.data.mongodb.password:}")
    private String password;

    @PostConstruct
    public void logMongoConfig() {
        log.info("=== MongoDB Configuration ===");
        if (!mongoUri.isEmpty()) {
            ConnectionString connectionString = new ConnectionString(mongoUri);
            log.info("URI: {}", maskPassword(mongoUri));
            log.info("Host: {}", connectionString.getHosts());
            log.info("Database: {}", connectionString.getDatabase());
            log.info("Username: {}", connectionString.getUsername());
        } else {
            log.info("Host: {}", host);
            log.info("Port: {}", port);
            log.info("Database: {}", database);
            log.info("Username: {}", username);
            log.info("Password: {}", maskPassword(password));
        }
        log.info("=============================");
    }

    private String maskPassword(String value) {
        if (value == null || value.isEmpty()) {
            return "NOT_SET";
        }
        return value.replaceAll(":[^@]+@", ":****@");
    }
}