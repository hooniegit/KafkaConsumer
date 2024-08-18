package com.example.KafkaConsumer.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class DataQueryService {

    private final JdbcTemplate jdbcTemplate;
    private final List<String> queryResults = new CopyOnWriteArrayList<>();

    @Autowired
    public DataQueryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Scheduled(cron = "0 0 0 * * ?") 
    public void performQuery() {
        String sql = "SELECT column_name FROM table_name";
        List<String> results = jdbcTemplate.queryForList(sql, String.class);

        // 새로운 결과로 리스트 갱신
        queryResults.clear();
        queryResults.addAll(results);

        System.out.println("Query executed and results updated: " + queryResults);
    }

    public List<String> getQueryResults() {
        return new CopyOnWriteArrayList<>(queryResults);
    }
}
