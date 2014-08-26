package no.bekk.java.exercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import static no.bekk.java.util.Utils.implementThis;

public class Ex1_Lambda {

	public static Function<Player, String> playerName = implementThis();

	public static Function<Player, Integer> playerAge = implementThis();

	public static Predicate<Player> isOlderThan(Integer age) {
		return implementThis();
	}

	static BinaryOperator<Player> youngestPlayer = implementThis();

	static BinaryOperator<Team> highestTeamValue = implementThis();

	static BinaryOperator<League> longestLeagueName = implementThis();
}
