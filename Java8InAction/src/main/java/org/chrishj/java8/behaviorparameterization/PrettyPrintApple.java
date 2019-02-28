package org.chrishj.java8.behaviorparameterization;

import java.util.Arrays;
import java.util.List;

/**
 * This stuff is verbose because you need to declare multiple classes that you instantiate only once.
 */
public class PrettyPrintApple {

	public static void main(String[] args) {
		List<Apple> lstApples = Arrays.asList(new Apple(10, "green"), new Apple(110, "red"));
		prettyPrintApple(lstApples, new AppleFancyFormatter());
		prettyPrintApple(lstApples, new AppleLightFormatter());
	}
	
	private static void prettyPrintApple(List<Apple> listApples, AppleFormatter appleFormatter) {
		for (Apple apple : listApples) {
			String out = appleFormatter.accept(apple);
			System.out.println(out);
		}
	}
	
	static class AppleFancyFormatter implements AppleFormatter{
		@Override
		public String accept(Apple a) {
			return "fancy: Color: " + a.getColor() + "weight: " + a.weight;
		}
		
	}
	
	static class AppleLightFormatter implements AppleFormatter{
		@Override
		public String accept(Apple a) {
			return "light: Color: " + a.getColor();
		}
	}
	
	private interface AppleFormatter{
		String accept(Apple a);	
	}
	
	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color){
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Apple{" +
					"color='" + color + '\'' +
					", weight=" + weight +
					'}';
		}
	}
}
