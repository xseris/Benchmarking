package it.xseris.benchmarking.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson {

  public long run(int times) throws IOException {
    long tot = 0;
    ClassLoader classLoader = Jackson.class.getClassLoader();
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
}
