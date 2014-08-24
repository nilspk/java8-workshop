package no.bekk.java.exercises;

import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ex1_Lambda {

    public static Function<Player, String> playerName = Player::getName;

    public static Function<Player, Integer> playerAge = Player::getAge;

    public static Predicate<Player> isOlderThan(Integer age) {
        return p -> p.getAge() > age;
    }

    static BinaryOperator<Player> youngestPlayer = (x, y) -> {
        if (x.birthDate.isAfter(y.birthDate)) return x;
        else return y;
    };

    static BinaryOperator<Team> highestTeamValue = (x, y) -> {
        if (x.value > y.value) return x;
        else return y;
    };

	//TODO: More exercises?
}
