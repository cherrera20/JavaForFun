package org.chrishj.java8.behaviorparameterization.streams.iterate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MarcExercise {

	public static void main(String[] args) {

		List<int[]> listOfNumbers = Stream
				.iterate(new int[] { 1, 2, 3 }, a -> new int[] { a[0] + 3, a[1] + 3, a[2] + 3 }).limit(3)
				.collect(Collectors.toList());
		
		IntStream.range(0, listOfNumbers.size()).boxed()
				.flatMap(n -> Stream.of(listOfNumbers).map(a -> new int[] { a.get(0)[n], a.get(1)[n], a.get(2)[n] }));
				
	}
}
