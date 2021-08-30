package pl.radzik.michal.modulbazydanych.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.radzik.michal.modulbazydanych.mapper.CarRowMapper;
import pl.radzik.michal.modulbazydanych.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CarDaoImpl implements CarDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void saveCar(int id, String mark, String model, String color, int year) {
        Car car = new Car(id, mark, model, color, year);
        String sql = "INSERT INTO cars VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getId(), car.getMark(), car.getModel(), car.getColor(), car.getYear());
    }


    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> cars.add(new Car(
                Integer.parseInt(String.valueOf(element.get("id"))),
                String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Integer.parseInt(String.valueOf(element.get("year"))
                ))));
        return cars;
    }

    @Override
    public List<Car> findByYearProduction(int yearFrom, int yearTo) {
        return jdbcTemplate.query
                ("SELECT * FROM cars where year between ? and ?",
                        new CarRowMapper(), yearFrom, yearTo);
    }
}
