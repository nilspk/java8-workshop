package no.bekk.java.exercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Ex3_LambdaWithStreams {

	static List<String> teamNames(List<Team> teams) {
		return teams.stream().map(Team::getName).collect(toList());
	}

	static Integer ageOfOldestPlayer(List<Player> players) {
		return players.stream().mapToInt(Player::getAge).max().getAsInt();
	}

	static Double averageAgeOfPlayers(List<Player> players) {
		return players.stream().mapToInt(Player::getAge).average().getAsDouble();
	}

	static String nameOfPlayerClosestToAverage(List<Player> players) {
		Double average = averageAgeOfPlayers(players);
		return players.stream().min(comparing(player -> Math.abs(player.getAge() - average))).get().getName();
	}

	static List<Player> playersWithNamesStartingWith(String start, List<Player> players) {
		return players.stream().filter(player -> player.name.startsWith(start)).collect(toList());
	}

	static Double sumValueOfAllTeams(List<Team> teams) {
		return teams.stream().collect(summingDouble(Team::getValue));
	}

	static Player youngestPlayer(List<Player> players) {
		return players.stream().reduce(Ex1_Lambda.youngestPlayer).get();
	}

	static Map<Integer, List<Player>> groupPlayersByBirthYear(List<Player> players) {
		return players.stream().collect(groupingBy(player -> player.getBirthDate().getYear(), toList()));
	}

	static Team teamWithHighestValue(final List<Team> teams) {
		return teams.stream().reduce(Ex1_Lambda.highestTeamValue).get();
	}

	static List<Double> sumValuesOfEachLeague(final List<League> leagues) {
		return leagues.stream()
				.map(league -> league.getTeams().stream()
                        .collect(summingDouble(Team::getValue)))
				.collect(toList());
	}

	static List<Player> playersBornBefore(final LocalDate minAge, final List<League> leagues) {
		return leagues.stream()
                .flatMap(league -> league.getTeams().stream())
                .flatMap(team -> team.getPlayers().stream())
                .filter(player -> player.birthDate.isBefore(minAge))
                .collect(toList());
	}

	static List<Player> sortByAgeAndThenName(final List<Player> players) {
		return players.stream().sorted(comparing(Player::getBirthDate).reversed().thenComparing(Player::getName)).collect(toList());
	}

	static Map<String, Player> youngestPlayerOnEachTeamMappedByTeamName(final List<Team> teams) {
		return teams.stream()
				.map(team -> new Team(team.name, team.value, Arrays.asList(team.players.stream().reduce(Ex1_Lambda.youngestPlayer).get())))
				.collect(toMap(Team::getName, team -> team.getPlayers().get(0)));
	}
}
