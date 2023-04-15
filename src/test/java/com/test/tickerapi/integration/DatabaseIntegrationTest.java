package com.test.tickerapi.integration;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class DatabaseIntegrationTest extends TCTest {
    @Autowired
    DatabaseCleanup databaseCleanup;

    @BeforeEach
    public void setup() {
        databaseCleanup.execute();
    }
}
