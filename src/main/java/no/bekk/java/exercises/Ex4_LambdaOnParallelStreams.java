package no.bekk.java.exercises;

import no.bekk.java.model.Team;

import java.util.List;
import java.util.function.Predicate;

import static no.bekk.java.util.Utils.implementThis;

public class Ex4_LambdaOnParallelStreams {

	static List<Team> teamsWithValueHigherThan(Double value, List<Team> teams) {
		return implementThis();
	}

	private static <T> Predicate<T> slowPredicate(Predicate<T> predicate) {
		return x -> {
			try{
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			return predicate.test(x);
		};
	}
}
