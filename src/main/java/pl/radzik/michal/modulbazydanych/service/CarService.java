package pl.radzik.michal.modulbazydanych.service;

import pl.radzik.michal.modulbazydanych.domain.Car;

import java.util.List;

public interface CarService {

    void saveCar(Car car);

    List<Car> getAllCars();

    List<Car> getCarsByRangYearOfProduction(int yearFrom, int yearTo);
}
