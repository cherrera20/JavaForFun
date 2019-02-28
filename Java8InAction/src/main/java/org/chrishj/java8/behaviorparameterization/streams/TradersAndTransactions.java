package org.chrishj.java8.behaviorparameterization.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lambdasinaction.chap5.Trader;
import lambdasinaction.chap5.Transaction;
import static java.util.Comparator.comparing;

public class TradersAndTransactions {

	public static void main(String[] args) {
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
		
		System.out.println("1 . Find all transactions in the year 2011 and sort them by value (small to high).");
		transactions.stream().filter(t -> t.getYear() == 2011).sorted(comparing(Transaction::getValue)).forEach(System.out::println);
		
		System.out.println("2 . What are all the unique cities where the traders work?");
		Stream.of(raoul, mario, alan, brian).map(t -> t.getCity()).distinct().forEach(System.out::println);
		
		System.out.println("3 . Find all traders from Cambridge and sort them by name.");
		Stream.of(raoul, mario, alan, brian).filter(t -> t.getCity().equals("Cambridge")).sorted(comparing(Trader::getName)).forEach(System.out::println);
		
		System.out.println("4 . Return a string of all traders’ names sorted alphabetically");
		String nombres = Stream.of(raoul, mario, alan, brian).map(t-> t.getName()).sorted().reduce("", (n1,n2) -> n1 + n2);
		System.out.println(nombres);
		
		System.out.println("5. Are any traders based in Milan?");
		boolean isTraderBaseInMilan = transactions.stream().filter(p -> p.getTrader().getCity().equals("Milan")).findAny().isPresent();
		System.out.println(isTraderBaseInMilan);
		
		System.out.println("6. Print all transactions’ values from the traders living in Cambridge.");
		transactions.stream().filter(p -> p.getTrader().getCity().equals("Cambridge")).map(m->m.getValue()).forEach(System.out::println);
		
		System.out.println("7 . What’s the highest value of all the transactions?");
		transactions.stream().map(m->m.getValue()).reduce(Integer::max).ifPresent(System.out::println);
		
		System.out.println("8 . What’s the smallest value of all the transactions?");
		transactions.stream().map(m->m.getValue()).reduce(Integer::min).ifPresent(System.out::println);
	}
}