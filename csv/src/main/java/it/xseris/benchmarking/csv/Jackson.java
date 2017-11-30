package it.xseris.benchmarking.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;

public class Jackson {

	public long run(int times) throws IOException {
		long tot = 0;

		ClassLoader classLoader = Jackson.class.getClassLoader();
		for (int i = 0; i < times; i++) {
			File file = new File(classLoader.getResource("test.csv").getFile());
			Reader in = new FileReader(file);

			CsvMapper mapper = new CsvMapper();
			mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
			long start = System.currentTimeMillis();
			MappingIterator<String[]> it = mapper.readerFor(String[].class).readValues(in);
			while (it.hasNext()) {
				String[] row = it.next();
			}

			long end = System.currentTimeMillis() - start;

			in.close();
			// System.out.println(end);
			tot += end;
		}
		return tot / times;
	}
}
