package no.bekk.java.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;

public class StreamOperationExamples {
	Stream<String> strings = Stream.of("1", "22", "333", "4444", "55555");
	Stream<Stream<String>> streams = Stream.of(strings);

	Stream<String> filtered = strings.filter(x -> x.length() < 3);
	Stream<String>mapped = strings.map(x -> x.substring(3));
	IntStream mappedToInt = strings.mapToInt(Integer::valueOf);
	LongStream mappedToLong = strings.mapToLong(Long::valueOf);
	DoubleStream mappedToDouble = strings.mapToDouble(Double::valueOf);
	Stream<String> flatMapped = streams.flatMap(s -> s.map(x -> x.substring(3)));
	IntStream flatMappedToInt = streams.flatMapToInt(s -> s.mapToInt(Integer::valueOf));
	LongStream flatMappedToLong = streams.flatMapToLong(s -> s.mapToLong(Long::valueOf));
	DoubleStream flatMappedToDouble = streams.flatMapToDouble(s -> s.mapToDouble(Double::valueOf));
	Stream<String> distinct = strings.distinct();
	Stream<String> sorted1 = strings.sorted();
	Stream<String> sorted2 = strings.sorted(Comparator.comparing(x -> x));
	void peak() {strings.peek(System.out::println);}
	Stream<String> limited = strings.limit(2);
	Stream<String> skip = strings.skip(1);

	void forEach() {strings.forEach(System.out::println);}
	void forEachSorted() {strings.forEachOrdered(System.out::println);}
	Object[] array1 = strings.toArray();
	String[] array2 = strings.toArray(i -> new String[i]);
	String concatenated = strings.reduce("", String::concat);
	Optional<String> concatenatedOpt = strings.reduce(String::concat);
	int sumLength = strings.mapToInt(String::length).sum();
	List<String> list = strings.collect(Collectors.toList());
	ArrayList<String> arrayList = strings.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	Optional<String> min = strings.min(Comparator.comparing(x -> x));
	Optional<String> max = strings.max(Comparator.comparing(x -> x));
	long count = strings.count();
	boolean anyMatch = strings.anyMatch(x -> x.length() > 3);
	boolean allMatch = strings.allMatch(x -> x.length() > 3);
	boolean noneMatch = strings.noneMatch(x -> x.length() > 3);
	Optional<String> first = strings.findFirst();
	Optional<String> anyString = strings.findAny();
}
