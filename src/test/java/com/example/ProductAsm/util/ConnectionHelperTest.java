package com.example.ProductAsm.util;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionHelperTest {

    @Test
    void testGetConnection() {
        Connection connection = ConnectionHelper.getConnection();
        assertNotEquals(null,connection);
    }
}