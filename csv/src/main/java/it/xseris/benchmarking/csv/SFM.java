package it.xseris.benchmarking.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.simpleflatmapper.csv.CsvParser;

public class SFM {

	public long run(int times) throws IOException {
		long tot = 0;

		ClassLoader classLoader = SFM.class.getClassLoader();
		for (int i = 0; i < times; i++) {
			File file = new File(classLoader.getResource("test.csv").getFile());
			Reader in = new FileReader(file);

			long start = System.currentTimeMillis();
			List<List<String>> rows = CsvParser.stream(in).map(Arrays::asList).collect(Collectors.toList());
			long end = System.currentTimeMillis() - start;

			in.close();
			rows = null;
			// System.out.println(end);
			tot += end;
		}
		return tot / times;
	}
}
