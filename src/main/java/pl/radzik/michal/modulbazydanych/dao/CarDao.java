package pl.radzik.michal.modulbazydanych.dao;

import pl.radzik.michal.modulbazydanych.domain.Car;

import java.util.List;

public interface CarDao {

    void saveCar(int id, String mark, String model, String color, int year);

    List<Car> findAll();

    List<Car> findByYearProduction(int yearFrom, int yearTo);

}
