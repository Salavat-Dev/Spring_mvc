package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    public List<Car> cars;

    @Override
    public List<Car> getAllCars(int count) {
        if (cars == null) {
            cars = new ArrayList<>();
        }
        cars.add(new Car("Red", "Ferrari", "V12"));
        cars.add(new Car("Blue", "Bugatti", "W16"));
        cars.add(new Car("Green", "Pagani", "V12"));
        cars.add(new Car("Yellow", "Lamborghini", "V10"));
        cars.add(new Car("White", "Maserati", "V8"));

        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
