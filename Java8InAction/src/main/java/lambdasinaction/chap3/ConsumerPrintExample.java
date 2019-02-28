package lambdasinaction.chap3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerPrintExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "ab", "c");
		forEach(list, (String a) -> System.out.println(a));
	}
	
	private static <T> void forEach(List<T> list, Consumer<T> c){
		for(T element: list) {
			c.accept(element);
		}
		
	}
}
