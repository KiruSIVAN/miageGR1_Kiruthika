package com.example.miageGR1.controller;

import com.example.miageGR1.data.Car;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars") 
public class CarController {

    private List<Car> cars = new ArrayList<>();

    public CarController() {
        cars.add(new Car("ABC123", 20000));
        cars.add(new Car("XYZ789", 30000));
    }

    @GetMapping
    public List<Car> getAllCars() {
        return cars;
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        cars.add(car);
        return car;
    }

    @GetMapping("/{plateNumber}")
    public Car getCarByPlateNumber(@PathVariable String plateNumber) {
        return cars.stream()
                .filter(car -> car.getPlateNumber().equals(plateNumber))
                .findFirst()
                .orElse(null); 
    }

    @PutMapping("/{plateNumber}/rent")
    public Car rentCar(@PathVariable String plateNumber) {
        Car car = getCarByPlateNumber(plateNumber);
        if (car != null) {
            car.setRented(true);
        }
        return car;
    }

    @DeleteMapping("/{plateNumber}")
    public String deleteCar(@PathVariable String plateNumber) {
        cars.removeIf(car -> car.getPlateNumber().equals(plateNumber));
        return "Car with plate number " + plateNumber + " removed.";
    }
}
