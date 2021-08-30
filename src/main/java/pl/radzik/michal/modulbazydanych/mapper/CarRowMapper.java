package pl.radzik.michal.modulbazydanych.mapper;

import org.springframework.jdbc.core.RowMapper;
import pl.radzik.michal.modulbazydanych.domain.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper<Car> {


    @Override
    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        Car car = new Car();
        car.setId(resultSet.getInt("id"));
        car.setMark(resultSet.getString("mark"));
        car.setModel(resultSet.getString("model"));
        car.setYear(resultSet.getInt("year"));

        return car;
    }
}
