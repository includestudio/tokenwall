package com.includestudio.tokenwall.support;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Since: 5/13/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RepositoryTestBase {

    protected JdbcTemplate jdbcTemplate;


    protected void clearTable(String tableName) {
        jdbcTemplate.execute("DELETE FROM "+ tableName);
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
