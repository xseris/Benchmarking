package it.xseris.benchmarking.json;

import com.jsoniter.output.JsonStream;

import java.io.IOException;

public class Jsoniterator {

  public long run(int times) throws IOException {
    long tot = 0;
    ClassLoader classLoader = Jsoniterator.class.getClassLoader();
    MostComplexPojo pojo = new MostComplexPojo();
    for (int i = 0; i < times; i++) {

      long start = System.currentTimeMillis();
      JsonStream.serialize(pojo);
      long end = System.currentTimeMillis() - start;

      System.out.println(end);
      tot += end;
    }
    return tot / times;
  }
}
