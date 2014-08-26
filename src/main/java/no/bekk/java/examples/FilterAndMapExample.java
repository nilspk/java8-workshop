package no.bekk.java.examples;

import no.bekk.java.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndMapExample {

    static class Java7 {

        public static List<String> getBrandOfExpensiveCars(List<Car> cars) {
            List<String> expensiveCarBrands = new ArrayList<>();
            for (Car car : cars) {
                if (car.price > 1_000_000) {
                    expensiveCarBrands.add(car.brand);
                }
            }
            return expensiveCarBrands;
        }

    }


    static class Java8 {
        public static List<String> getBrandOfExpensiveCars(List<Car> cars) {
            return cars.stream()
                    .filter(c -> c.price > 1_000_000)
                    .map(Car::getBrand)
                    .collect(Collectors.toList());
        }
    }

}
