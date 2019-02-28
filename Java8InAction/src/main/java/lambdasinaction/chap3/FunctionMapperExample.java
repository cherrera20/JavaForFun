package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionMapperExample {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "aa", "aaa");
		System.out.println(map(list, (String s) -> s.length()));
	}
	
	private static <T, R> List<R> map(List<T> list, Function<T, R> f){
		List<R> resultado = new ArrayList<>();
		for (T el : list) {
			resultado.add(f.apply(el));
		}
		return resultado;
	}
}
