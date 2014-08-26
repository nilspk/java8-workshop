package no.bekk.java.exercises;

import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.time.LocalDate;
import java.util.Optional;

import static java.util.Comparator.comparing;

public class Ex5_Optional {

    static Optional<Player> youngestPlayerOlderThan(Team team, LocalDate minDate) {
        return team.getPlayers().stream()
                .filter(player -> player.birthDate.isBefore(minDate))
                .max(comparing(Player::getBirthDate));
    }
}
