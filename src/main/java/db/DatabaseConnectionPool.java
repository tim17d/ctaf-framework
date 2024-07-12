package db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.Map;

public class DatabaseConnectionPool {

    private final Map<String, HikariDataSource> dataSourceMap = new HashMap<>();

    public void addDataSource(String dbName, String url, String username, String password, String driverClassName) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driverClassName);

        HikariDataSource dataSource = new HikariDataSource(config);
        dataSourceMap.put(dbName, dataSource);
    }

    public void addTestDataSource() {
        addDataSource("testDB", "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "", "org.h2.Driver");
    }

    public JdbcTemplate getJdbcTemplate(String dbName) {
        HikariDataSource dataSource = dataSourceMap.get(dbName);
        if (dataSource == null) {
            throw new IllegalArgumentException("No DataSource found for database: " + dbName);
        }
        return new JdbcTemplate(dataSource);
    }

    public void closeAll() {
        dataSourceMap.values().stream()
                .filter(dataSource -> dataSource != null && !dataSource.isClosed())
                .forEach(HikariDataSource::close);
    }
}
