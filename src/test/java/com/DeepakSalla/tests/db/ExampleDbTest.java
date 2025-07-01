package com.DeepakSalla.tests.db;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExampleDbTest {

    private Connection conn;
    private Statement stmt;

    @BeforeClass
    public void setUpDb() throws Exception {
        conn = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        stmt = conn.createStatement();
        stmt.execute("CREATE TABLE users(id INT PRIMARY KEY, name VARCHAR(50))");
        stmt.execute("INSERT INTO users VALUES(1, 'Alice')");
    }

    @Test
    public void verifyUserInDb() throws Exception {
        ResultSet rs = stmt.executeQuery("SELECT name FROM users WHERE id = 1");
        if (rs.next()) {
            String name = rs.getString("name");
            assert "Alice".equals(name) : "Expected Alice but was " + name;
        } else {
            throw new AssertionError("No user with id=1");
        }
    }

    @AfterClass
    public void tearDownDb() throws Exception {
        stmt.execute("DROP TABLE users");
        stmt.close();
        conn.close();
    }
}
