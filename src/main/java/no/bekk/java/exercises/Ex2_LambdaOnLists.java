package no.bekk.java.exercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class Ex2_LambdaOnLists {

	static List<Player> removeOldPlayers(LocalDate maxAge, List<Player> players) {
		List<Player> result = new ArrayList<>(players.size());
		players.forEach(player -> {
			if(player.birthDate.compareTo(maxAge) > 0) result.add(player);
		});
		return result;
	}

	static List<Team> addValueToEachTeam(Double percent, List<Team> teams) {
		List<Team> result = new ArrayList<>(teams.size());
		teams.forEach(team -> result.add(new Team(team.name, team.value * (percent + 1), team.players)));
		return result;
	}

	static List<League> setLeagueNamesToUpperCase(List<League> leagues) {
		List<League> result = new ArrayList<>(leagues.size());
		leagues.forEach(league -> result.add(new League(league.name.toUpperCase(), league.teams)));
		return result;
	}

	static void removeTeamsWithLowValue(List<Team> teams, Double minValue) {
		teams.removeIf(team -> team.value < minValue);
	}
}
