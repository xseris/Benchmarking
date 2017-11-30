package it.xseris.benchmarking.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CommonsCSV {

	public long run(int times) throws IOException {
		long tot = 0;
		ClassLoader classLoader = CommonsCSV.class.getClassLoader();
		for (int i = 0; i < times; i++) {
			File file = new File(classLoader.getResource("test.csv").getFile());
			Reader in = new FileReader(file);
			CSVParser parser = new CSVParser(in, CSVFormat.RFC4180);

			long start = System.currentTimeMillis();
			List<CSVRecord> list = parser.getRecords();
			long end = System.currentTimeMillis() - start;

			in.close();
			list = null;
			// System.out.println(end);
			tot += end;
		}
		return tot / times;
	}

}
