package org.chrishj.java8.behaviorparameterization.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SpecialVoidCompatibility {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("a");
		Predicate<String> pred = (a) -> list.add(a);
		Consumer<String> consumer = (a) -> list.add(a);
		Consumer<Integer> consum = (i) -> ++i;
	}
}
