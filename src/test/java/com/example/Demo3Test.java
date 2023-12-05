package com.example;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.sql.Connection;
import java.sql.Statement;

@MicronautTest
class Demo3Test {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    Connection connection;
    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testReturnGeneratedKeys() throws Exception {
        connection.prepareStatement("SELECT 'Hello world' FROM DUAL", Statement.RETURN_GENERATED_KEYS);
    }
}
