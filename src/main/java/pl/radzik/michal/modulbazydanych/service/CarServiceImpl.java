package pl.radzik.michal.modulbazydanych.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.radzik.michal.modulbazydanych.dao.CarDao;
import pl.radzik.michal.modulbazydanych.domain.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }


    @Override
    public void saveCar(Car car) {
        carDao.saveCar(car.getId(), car.getMark(), car.getModel(), car.getColor(), car.getYear());
    }

    public List<Car> getAllCars() {
        return carDao.findAll();
    }

    public List<Car> getCarsByRangYearOfProduction(int yearFrom, int yearTo) {
        return carDao.findByYearProduction(yearFrom, yearTo);
    }

}
