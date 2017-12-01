package it.xseris.benchmarking.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JacksonJSON {

  public long runSer(int times) throws IOException {
    long tot = 0;
    MostComplexPojo pojo = new MostComplexPojo();
    ObjectMapper objectMapper = new ObjectMapper();
    for (int i = 0; i < times; i++) {

      long start = System.currentTimeMillis();
      objectMapper.writeValueAsString(pojo);
      long end = System.currentTimeMillis() - start;

      System.out.println(end);
      tot += end;
    }
    objectMapper.writeValue(new File("pojo.json"), pojo);
    return tot / times;
  }

  public long runDeser(int times) throws IOException {
    long tot = 0;
    ClassLoader classLoader = JacksonJSON.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    for (int i = 0; i < times; i++) {
      File file = new File(classLoader.getResource("pojo.json").getFile());
      Reader in = new FileReader(file);

      long start = System.currentTimeMillis();
      objectMapper.readValue(in, MostComplexPojo.class);
      long end = System.currentTimeMillis() - start;

      System.out.println(end);
      in.close();
      tot += end;
    }
    return tot / times;
  }
}
