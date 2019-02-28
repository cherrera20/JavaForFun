package org.chrishj.java8.behaviorparameterization.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMap {

	public static void main(String[] args) {
		
		List<Integer> lista = Arrays.asList(1,2,3,4,5);
		lista.stream().map(numero -> numero*numero).forEach(System.out::println);
		
		List<Integer> numbers1 = Arrays.asList(1, 2, 3); 
		List<Integer> numbers2 = Arrays.asList(3, 4);
		
		List pairs =  numbers1.stream().flatMap(n -> numbers2.stream().map(m -> new int[] {n,m})).collect(Collectors.toList());
		System.out.println(pairs);
		
		numbers1.stream().flatMap(n -> numbers2.stream().filter(m -> (m+n) % 3 == 0).map(m -> new int[] {n,m})).collect(Collectors.toList());
				
		
	}
	
	
}
