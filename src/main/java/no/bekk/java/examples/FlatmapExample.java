package no.bekk.java.examples;

import no.bekk.java.model.Car;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FlatmapExample {

    static class Java7 {

        public static List<Player> getPlayerPlayer(List<Team> teams) {
            List<Player> players = new ArrayList<>();
            for (Team team : teams) {
                players.addAll(team.getPlayers());
            }
            return players;
        }

    }


    static class Java8 {
        public static List<Player> getPlayerPlayer(List<Team> teams) {
            return teams.stream()
                    .flatMap(team -> team.getPlayers().stream())
                    .collect(Collectors.toList());
        }
    }
}
