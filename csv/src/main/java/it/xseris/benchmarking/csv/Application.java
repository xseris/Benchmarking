package it.xseris.benchmarking.csv;

import java.io.IOException;

public class Application {
	
	private static final int TIMES = 100;
	
	public static void main(String[] args) throws IOException {
		Univocity univocity = new Univocity();
		CommonsCSV commonsCsv = new CommonsCSV();
		OpenCSV openCSV = new OpenCSV();
		BytecodeOpenCSV bytecodeOpenCSV = new BytecodeOpenCSV();
		SFM sfm = new SFM();
		Jackson jackson = new Jackson();

		System.out.println("Univocity took: " + univocity.run(TIMES));
		System.out.println("Commons CSV took: " + commonsCsv.run(TIMES));
		System.out.println("OpenCSV took: " + openCSV.run(TIMES));
		System.out.println("BytecodeOpenCSV took: " + bytecodeOpenCSV.run(TIMES));
		System.out.println("SFM took: " + sfm.run(TIMES));
		System.out.println("Jackson took: " + jackson.run(TIMES));
	}
}
