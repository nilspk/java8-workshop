package no.bekk.java.examples;

import no.bekk.java.model.Car;

import java.util.*;
import java.util.stream.Collectors;

public class CarExamples {

    static class Java7 {

        public static List<String> brandsSortedByPrice(List<Car> cars) {
            List<Car> carsSortedByPrice = new ArrayList<>();
            List<String> brands = new ArrayList<>();
            for (Car car : cars) {
                int i = 0;
                while (i < carsSortedByPrice.size() && carsSortedByPrice.get(i).getPrice() < car.getPrice()) {
                    i++;
                }
                carsSortedByPrice.add(i, car);
                brands.add(i, car.getBrand());
            }
            return brands;
        }

    }


    static class Java8 {
        public static List<String> brandsSortedByPrice(List<Car> cars) {
            return cars.stream()
                    .sorted(Comparator.comparing(Car::getPrice))
                    .map(Car::getBrand)
                    .collect(Collectors.toList());
        }
    }

    public static String parse(String string) {
        return string.replace("<", "&lt;").replace(">", "&gt;");
    }

    public static void main(String[] args) {
        System.out.println(parse("Stream<T> sorted(Comparator<? super T> comparator);"));
    }

}

