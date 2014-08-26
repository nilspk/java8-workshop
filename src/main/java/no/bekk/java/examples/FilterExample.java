package no.bekk.java.examples;

import no.bekk.java.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class FilterExample {

    static class Java7 {

        public static List<Car> getExpensiveCars(List<Car> cars) {
            List<Car> expensiveCars = new ArrayList<>();
            for (Car car : cars) {
                if (car.price > 1_000_000) {
                    expensiveCars.add(car);
                }
            }
            return expensiveCars;
        }

    }


    static class Java8 {
        public static List<Car> getExpensiveCars(List<Car> cars) {
            return cars.stream()
                    .filter(c -> c.price > 1_000_000)
                    .collect(Collectors.toList());
        }
    }

}
