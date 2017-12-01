package it.xseris.benchmarking.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class BytecodeOpenCSV {

	public long run(int times) throws IOException {
		long tot = 0;

		ClassLoader classLoader = BytecodeOpenCSV.class.getClassLoader();
		for (int i = 0; i < times; i++) {
			File file = new File(classLoader.getResource("test.csv").getFile());
			Reader in = new FileReader(file);

			CSVReader reader = new CSVReader(in, ',', '"', 0);

			long start = System.currentTimeMillis();
			List<String[]> rows = reader.readAll();
			long end = System.currentTimeMillis() - start;

			in.close();
			rows = null;
			System.out.println(end);
			tot += end;
		}
		return tot / times;
	}
}
