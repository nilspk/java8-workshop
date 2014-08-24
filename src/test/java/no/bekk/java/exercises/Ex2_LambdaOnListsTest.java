package no.bekk.java.exercises;

import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static no.bekk.java.model.Data.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class Ex2_LambdaOnListsTest {

	@Test
	public void testRemoveCheapTeams() {
		List<Team> teams = new ArrayList<>(asList(manchesterUnited, liverpool, arsenal, borussiaDortmund, atleticoMadrid));

		Ex2_LambdaOnLists.removeCheapTeams(teams, 1_330_000_000.0);

		assertThat(teams, hasItems(manchesterUnited, arsenal));
		assertThat(teams, not(hasItems(liverpool, borussiaDortmund, atleticoMadrid)));
	}

	@Test
	public void testAddValueToEachTeam() {
		List<Team> teams = asList(manchesterUnited, liverpool, arsenal);

		List<Team> teamsWithFivePercentValueIncrease = Ex2_LambdaOnLists.addValueToEachTeam(0.05, teams);

		assertThat(round(teamsWithFivePercentValueIncrease.get(0).value), is(round(2_950_500_000.0)));
		assertThat(round(teamsWithFivePercentValueIncrease.get(1).value), is(round(725_550_000.0)));
		assertThat(round(teamsWithFivePercentValueIncrease.get(2).value), is(round(1_396_500_000.0)));
	}

	@Test
	public void testSortByAgeAndThenName() {
		Player juanMattaClone = new Player(juanMatta.name+"clone", juanMatta.birthDate);
		List<Player> players = asList(wayneRooney, juanMattaClone, danielAlves, juanMatta, diegoCosta);

		Ex2_LambdaOnLists.sortByAgeAndThenName(players);

		assertThat(players.get(0), is(diegoCosta));
		assertThat(players.get(1), is(juanMatta));
		assertThat(players.get(2), is(juanMattaClone));
		assertThat(players.get(3), is(wayneRooney));
		assertThat(players.get(4), is(danielAlves));
	}

	@Test
	public void testRemoveOldPlayers() {
		List<Player> result = Ex2_LambdaOnLists.removeOldPlayers(LocalDate.of(1984, 1, 1), bayernMunchen.players);
		result.forEach(System.out::println);
		assertThat(result, hasItems(arjenRobben));
		assertThat(result, not(hasItems(philippLahm, franckRibery)));
	}

	private BigDecimal round(Double d) {
		return new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
