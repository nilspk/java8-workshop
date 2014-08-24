package no.bekk.java.exercises;

import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static no.bekk.java.model.Data.arjenRobben;
import static no.bekk.java.model.Data.bayernMunchen;
import static no.bekk.java.model.Data.franckRibery;
import static no.bekk.java.model.Data.liverpool;
import static no.bekk.java.model.Data.manchesterUnited;
import static no.bekk.java.model.Data.stevenGerrard;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Ex1_LambdaTest {

    @Test
    public void getNameFromPlayers() {
        List<String> names = manchesterUnited.getPlayers().stream().map(Ex1_Lambda.playerName).collect(toList());
        assertThat(names, is(asList("Wayne Rooney", "Juan Matta", "Robin van Persie")));
    }

    @Test
    public void getAgeFromPlayers() {
        List<Integer> ages = bayernMunchen.getPlayers().stream().map(Ex1_Lambda.playerAge).collect(toList());
        assertThat(ages, is(asList(31, 30, 30)));
    }

    @Test
    public void onlyKeepsPlayersOver30() {
        List<Player> oldPlayers = liverpool.getPlayers().stream().filter(Ex1_Lambda.isOlderThan(30)).collect(toList());
        assertThat(oldPlayers, is(asList(stevenGerrard)));
    }

    @Test
    public void testYoungestPlayerLambda() {
        Player youngestPlayer = Ex1_Lambda.youngestPlayer.apply(franckRibery, arjenRobben);

        assertThat(youngestPlayer, is(arjenRobben));
    }

    @Test
    public void testHighestTeamValueLambda() {
        Team teamWithHighestValue = Ex1_Lambda.highestTeamValue.apply(manchesterUnited, liverpool);

        assertThat(teamWithHighestValue, is(manchesterUnited));
    }
}
