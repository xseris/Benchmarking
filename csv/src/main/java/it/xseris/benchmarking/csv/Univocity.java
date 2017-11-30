package it.xseris.benchmarking.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

public class Univocity {

	public long run(int times) throws IOException {
		long tot = 0;

		ClassLoader classLoader = Univocity.class.getClassLoader();
		for (int i = 0; i < times; i++) {
			File file = new File(classLoader.getResource("test.csv").getFile());
			Reader in = new FileReader(file);

			CsvParserSettings parserSettings = new CsvParserSettings();
			parserSettings.setLineSeparatorDetectionEnabled(true);
			RowListProcessor rowProcessor = new RowListProcessor();
			parserSettings.setProcessor(rowProcessor);
			parserSettings.setHeaderExtractionEnabled(true);
			CsvParser parser = new CsvParser(parserSettings);

			long start = System.currentTimeMillis();
			parser.parse(in);
			String[] headers = rowProcessor.getHeaders();
			List<String[]> rows = rowProcessor.getRows();
			long end = System.currentTimeMillis() - start;

			in.close();
			rows = null;
			// System.out.println(end);
			tot += end;
		}
		return tot / times;
	}
}
