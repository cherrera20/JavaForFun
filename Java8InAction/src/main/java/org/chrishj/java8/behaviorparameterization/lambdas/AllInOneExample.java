package org.chrishj.java8.behaviorparameterization.lambdas;

import java.util.Arrays;
import static java.util.Comparator.comparing;
import java.util.List;

public class AllInOneExample {
	
	public static void main(String[] args) {

		List<Apple> list = Arrays.asList(
				new Apple("1", 100),
				new Apple("2", 50),
				new Apple("3", 75));
		
		list.sort( (a,b) -> a.getWeight().compareTo(b.getWeight()));
		list.sort(comparing((a) -> a.getWeight()));
		list.sort(comparing((Apple::getWeight)));
		
		System.out.println(list);
	}
}