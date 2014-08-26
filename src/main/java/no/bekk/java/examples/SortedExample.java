package no.bekk.java.examples;

import no.bekk.java.model.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {

    static class Java7 {

        public static List<Car> sortedByPrice(List<Car> cars) {
            List<Car> carsSortedByPrice = new ArrayList<>();
            for (Car car : cars) {
                int i = 0;
                while (i < carsSortedByPrice.size() && carsSortedByPrice.get(i).getPrice() < car.getPrice()) {
                    i++;
                }
                carsSortedByPrice.add(i, car);
            }
            return carsSortedByPrice;
        }

    }


    static class Java8 {
        public static List<Car> sortedByPrice(List<Car> cars) {
            return cars.stream()
                    .sorted(Comparator.comparing(Car::getPrice))
                    .collect(Collectors.toList());
        }
    }

}
