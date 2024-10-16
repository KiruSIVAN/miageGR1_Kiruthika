package com.example.miageGR1.web;

import com.example.miageGR1.data.Car;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarRental {

    List<Car> cars = new ArrayList<Car>();

    public CarRental() {
        cars.add(new Car("11AA22", 1000));
        cars.add(new Car("22BB33", 2000));
    }

    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars(){
        return cars;
    }

    @PutMapping(value = "/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrGetBack(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value="rent", required = true)boolean rent) throws Exception{
            System.out.println(plateNumber);
            System.out.println(rent);
            Iterator<Car> carIterator = cars.iterator();
            Car carFounded = null;
            while(carIterator.hasNext() && (carFounded=carIterator.next()).getPlateNumber().equals(plateNumber)==false){
            }
            if(carFounded != null){      // voiture trouvée
                if(rent == true){
                    carFounded.setRented(true);
                } else {
                    carFounded.setRented(false);
                }
            } else {
                throw new Exception("Car does not exist");
            }
    }
}
