package org.chrishj.java8.behaviorparameterization.streams.iterate;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciTuples {

	public static void main(String[] args) {
		
		/*
		 * ITERATE approach
		 */
		Stream.iterate(0, t -> t + 1).limit(20)
		.forEach(t -> System.out.println(t));
		
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(20)
				.forEach(t -> System.out.println(t[0] + "," + t[1]));
		
		/*
		 * GENERATE approach
		 */
		/*
		IntStream ones = IntStream.generate(() -> 1).limit(10);
		ones.forEach(n -> System.out.println(n));
		*/
		
		// with anonymous class We can define state via fiels:
		IntStream twos = IntStream.generate(new IntSupplier() {
			private int previous = 0;
			private int current = 1;
			
			@Override
			public int getAsInt() {
				int oldPrevious = this.previous;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return oldPrevious;
			}
		});
		twos.limit(10).forEach(n -> System.out.println(n));
	}
}
