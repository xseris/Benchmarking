package it.xseris.benchmarking.csv;

import java.io.IOException;

public class Application {
	
	private static final int TIMES = 100;
	
	public static void main(String[] args) throws IOException {
		Univocity univocity = new Univocity();
		System.out.println("Univocity took: " + univocity.run(TIMES));
		CommonsCSV commonsCsv = new CommonsCSV();
		System.out.println("Commons CSV took: " + commonsCsv.run(TIMES));
		OpenCSV openCSV = new OpenCSV();
		System.out.println("OpenCSV took: " + openCSV.run(TIMES));
		SFM sfm = new SFM();
		System.out.println("SFM took: " + sfm.run(TIMES));
		Jackson jackson = new Jackson();
		System.out.println("Jackson took: " + jackson.run(TIMES));
	}
}
