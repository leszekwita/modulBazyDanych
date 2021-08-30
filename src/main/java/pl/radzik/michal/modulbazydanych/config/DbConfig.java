package pl.radzik.michal.modulbazydanych.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    private DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    /*@EventListener(ApplicationReadyEvent.class)
   public void init() {
        String sql = "CREATE TABLE cars(id int, mark varchar(255), model varchar(255), color varchar(255), year int, PRIMARY KEY (id))";
        getJdbcTemplate().update(sql);
    }*/
}
