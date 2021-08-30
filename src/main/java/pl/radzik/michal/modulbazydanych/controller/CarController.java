package pl.radzik.michal.modulbazydanych.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.radzik.michal.modulbazydanych.domain.Car;
import pl.radzik.michal.modulbazydanych.service.CarService;
import pl.radzik.michal.modulbazydanych.utils.CarFilter;

import java.util.Comparator;
import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("newCar", new Car());
        model.addAttribute("carFilter", new CarFilter());
        return "cars";
    }

    @PostMapping("/carFilter")
    public String getCarsByProductionYear(Model model, @ModelAttribute(value = "carFilter") CarFilter carFilter) {
        List<Car> cars = carService.getCarsByRangYearOfProduction(carFilter.getYearFrom(), carFilter.getYearTo());
        model.addAttribute("cars", cars);
        model.addAttribute("newCar", new Car());
        return "cars";
    }

    @PostMapping(value = "/newCar")
    public String addCar(@ModelAttribute("car") Car car) {
        List<Car> cars = carService.getAllCars();
        if (cars != null) {
            int indexMax = carService.getAllCars().stream()
                    .max(Comparator.comparing(Car::getId)).get().getId();
            car.setId(++indexMax);
        } else {
            car.setId(1);
        }
        carService.saveCar(car);
        return "redirect:/cars";
    }
}
