package com.test.tickerapi.integration;

import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public abstract class TCTest {
    @Container
    private static final MySQLContainer mySQLContainer;

    static {
        mySQLContainer = new MySQLContainer(DockerImageName.parse("mysql:5.7.36"))
                .withDatabaseName("ticker")
                .withUsername("test")
                .withPassword("test");
        mySQLContainer.start();
    }
}
