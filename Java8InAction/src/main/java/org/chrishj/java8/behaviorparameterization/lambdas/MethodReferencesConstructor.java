package org.chrishj.java8.behaviorparameterization.lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MethodReferencesConstructor {
	
	static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
	static {
		map.put("apple", Apple::new);
	}
	
	public static void main(String[] args) {
		Fruit a = giveMeFruit("apple", 2);	
		System.out.println(a.toString());
	}
	
	static Fruit giveMeFruit(String name, Integer weight) {
		return map.get(name).apply(weight);
	}
}

class Fruit{
}

class Apple extends Fruit{
	private Integer weight;
	private String color;
	
	public Apple(Integer weight){
		this.weight = weight;
	}
	public Apple(String color, Integer weight){
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
