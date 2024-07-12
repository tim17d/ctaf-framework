package autotests;

import db.DatabaseConnectionPool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class H2DbTest {

    private DatabaseConnectionPool connectionPool;

    @BeforeEach
    public void setUp() {
        connectionPool = new DatabaseConnectionPool();
        connectionPool.addTestDataSource();
    }

    @AfterEach
    public void tearDown() {
        connectionPool.closeAll();
    }

    @Test
    public void testH2Db() {
        JdbcTemplate jdbcTemplate = connectionPool.getJdbcTemplate("testDB");
        jdbcTemplate.execute("CREATE TABLE test (id INT PRIMARY KEY, name VARCHAR(255))");
        jdbcTemplate.execute("INSERT INTO test (id, name) VALUES (1, 'Test Name')");
        String name = jdbcTemplate.queryForObject("SELECT name FROM test WHERE id = 1", String.class);
        assertEquals("Test Name", name);
    }
}
