package com.includestudio.tokenwall.infrastructure.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Since: 5/21/12
 */
@Configuration
public class DataSourceConfig {

    private  String driverClass = "org.hsqldb.jdbcDriver";
    private  String jdbcUrl = "jdbc:hsqldb:mem:batch";
    private  String sa = "sa";
    private  String password = "";
    private  int idleConnectionTestPeriod = 10;
    private  String preferredTestQuery = "SELECT 1";

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws PropertyVetoException {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driverClass);
        comboPooledDataSource.setJdbcUrl(jdbcUrl);
        comboPooledDataSource.setUser(sa);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
        comboPooledDataSource.setPreferredTestQuery(preferredTestQuery);
        return comboPooledDataSource;

    }


    @Value("#{jdbcProperties['jdbc.connection.driver.class']}")
    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    @Value("#{jdbcProperties['jdbc.connection.url']}")
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    @Value("#{jdbcProperties['jdbc.connection.username']}")
    public void setSa(String sa) {
        this.sa = sa;
    }

    @Value("#{jdbcProperties['jdbc.connection.password']}")
    public void setPassword(String password) {
        this.password = password;
    }

    @Value("#{jdbcProperties['jdbc.connection.test.period']}")
    public void setIdleConnectionTestPeriod(int idleConnectionTestPeriod) {
        this.idleConnectionTestPeriod = idleConnectionTestPeriod;
    }

    @Value("#{jdbcProperties['jdbc.connection.test.query']}")
    public void setPreferredTestQuery(String preferredTestQuery) {
        this.preferredTestQuery = preferredTestQuery;
    }
}
