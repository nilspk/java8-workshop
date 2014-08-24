package no.bekk.java.exercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static no.bekk.java.model.Data.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Ex1_LambdaTest {

    @Test
    public void testPlayerName() {
        List<String> names = manchesterUnited.getPlayers().stream().map(Ex1_Lambda.playerName).collect(toList());
        assertThat(names, is(asList("Wayne Rooney", "Juan Matta", "Robin van Persie")));
    }

    @Test
    public void testPlayerAge() {
        List<Integer> ages = bayernMunchen.getPlayers().stream().map(Ex1_Lambda.playerAge).collect(toList());
        assertThat(ages, is(asList(31, 30, 30)));
    }

    @Test
    public void testIsOlderThan() {
		final int MIN_AGE = 30;
        List<Player> oldPlayers = liverpool.getPlayers().stream().filter(Ex1_Lambda.isOlderThan(MIN_AGE)).collect(toList());
        assertThat(oldPlayers, is(asList(stevenGerrard)));
    }

    @Test
    public void testYoungestPlayer() {
        Player youngestPlayer = Ex1_Lambda.youngestPlayer.apply(franckRibery, arjenRobben);

        assertThat(youngestPlayer, is(arjenRobben));
    }

    @Test
    public void testHighestTeamValue() {
        Team teamWithHighestValue = Ex1_Lambda.highestTeamValue.apply(manchesterUnited, liverpool);

        assertThat(teamWithHighestValue, is(manchesterUnited));
    }

	@Test
	public void testLongestLeagueName () {
		League leagueWithLongestName = Ex1_Lambda.longestLeagueName.apply(laLiga, premierLeague);

		assertThat(leagueWithLongestName, is(premierLeague));
	}
}
