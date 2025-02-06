package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.stream.Collectors;


@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    private String showCars(@RequestParam(name = "count", required = false, defaultValue = "5") Integer count, Model model) {
        if (count >= 5) {
            model.addAttribute("cars", carService.getAllCars(5));
        }
        model.addAttribute("cars", carService.getAllCars(count));
        return "cars";
    }
}
