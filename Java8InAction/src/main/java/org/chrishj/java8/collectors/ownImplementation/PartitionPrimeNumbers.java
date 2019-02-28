package org.chrishj.java8.collectors.ownImplementation;

import java.util.List;
import java.util.function.Predicate;

public class PartitionPrimeNumbers {
	
	public static boolean isPrime(List<Integer> primes, int candidate) {
		return primes.stream().noneMatch(i -> candidate % i ==0);		
	}

	
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }
    
}
