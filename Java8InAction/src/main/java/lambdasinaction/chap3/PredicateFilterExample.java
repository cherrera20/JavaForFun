package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFilterExample {

	public static void main(String[] args) {
		List<String> cosas = Arrays.asList("a", "ab", "c");
		System.out.println(filter(cosas, (String a) -> a.endsWith("b")));
	}

	private static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> resultado = new ArrayList<>();
		for (T el : list) {
			if (p.test(el)) {
				resultado.add(el);
			}
		}
		return resultado;
	}
}