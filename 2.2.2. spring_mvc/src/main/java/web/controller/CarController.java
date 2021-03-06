package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam(value = "count", required = false) Integer count) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Москвич", "412", 1967));
        cars.add(new Car("ВАЗ", "2101", 1970));
        cars.add(new Car("ЗАЗ", "968", 1975));
        cars.add(new Car("Opel", "Astra", 1995));
        cars.add(new Car("Peugeot", "Partner", 2002));

        model.addAttribute("cars",
                (count == null || count >= 5) ? cars: cars.stream().limit(count).collect(Collectors.toList()));
        return "cars";
    }
}
