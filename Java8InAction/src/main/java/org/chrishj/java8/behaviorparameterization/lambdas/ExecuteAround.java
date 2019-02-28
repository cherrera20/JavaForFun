package org.chrishj.java8.behaviorparameterization.lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {

	public static void main(String[] args) {
		try {
			// 1
			// processFile();
			// 2 pensando en parametrizar el comportamiento
			// processFile( (BufferedReader br) -> br.readLine ); // La firma seria dado un
			// BR devuelvo un String
			String out = processFile((BufferedReader br) -> br.readLine() + "\n" + br.readLine());

			System.out.println(out);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String processFile() throws IOException {
		String file = ClassLoader.getSystemClassLoader().getResource("lambdasinaction/chap3/data.txt").getFile();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			return br.readLine();
		}
	}

	private static String processFile(BufferedReaderPredicate predicate) throws IOException {
		String file = ClassLoader.getSystemClassLoader().getResource("lambdasinaction/chap3/data.txt").getFile();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			return predicate.process(br);
		}

	}

}

@FunctionalInterface
interface BufferedReaderPredicate {
	String process(BufferedReader br) throws IOException;
}