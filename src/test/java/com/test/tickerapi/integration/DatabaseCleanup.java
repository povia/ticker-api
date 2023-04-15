package com.test.tickerapi.integration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Service
@ActiveProfiles("test")
public class DatabaseCleanup {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void execute() {
        List<String> tableNames = (List<String>) entityManager.createNativeQuery("show tables").getResultList();
        entityManager.flush();
        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();

        for (String tableName : tableNames) {
            entityManager.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate();
            entityManager.createNativeQuery("ALTER TABLE " + tableName + " AUTO_INCREMENT = 1")
                    .executeUpdate();
        }

        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();
    }
}
