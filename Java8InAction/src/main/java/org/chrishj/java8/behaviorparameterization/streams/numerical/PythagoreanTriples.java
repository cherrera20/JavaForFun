package org.chrishj.java8.behaviorparameterization.streams.numerical;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriples {

	public static void main(String[] args) {

		// Generator of pythagorean triples
		IntStream.rangeClosed(1, 100).filter(a -> Math.sqrt(a * a + 12) % 1 == 0);

		// IntStream.rangeClosed(0, 100).filter(a -> Math.sqrt(a * a + 12) % 1 ==
		// 0).boxed().map(l -> new int[] {1,2,3});
		// IntStream.rangeClosed(0, 100).filter(a -> Math.sqrt(a * a + 12) % 1 ==
		// 0).mapToObj(l -> new int[] {1,2,3});

		Stream<int[]> res = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
						.mapToObj(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }));

		// res.limit(5).forEach(x -> System.out.println(x[0] +"," + x[1] + "," + x[2]));

		// Anoher wat to do the above:

		Stream<double[]> result = IntStream.rangeClosed(1, 100).boxed().flatMap(
				a -> IntStream.rangeClosed(a, 100).mapToObj(b -> new double[] { a, b, Math.sqrt(a * a + b * b) })
				.filter(t -> t[2] % 1 == 0));

		result.limit(5).forEach(x -> System.out.println(x[0] + "," + x[1] + "," + x[2]));

	}
}
