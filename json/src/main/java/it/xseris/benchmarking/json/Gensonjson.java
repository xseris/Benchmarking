package it.xseris.benchmarking.json;

import com.owlike.genson.Genson;

import java.io.IOException;

public class Gensonjson {

  public long run(int times) throws IOException {
    long tot = 0;
    ClassLoader classLoader = Gensonjson.class.getClassLoader();
    MostComplexPojo pojo = new MostComplexPojo();
    Genson genson = new Genson();
    for (int i = 0; i < times; i++) {

      long start = System.currentTimeMillis();
      genson.serialize(pojo);
      long end = System.currentTimeMillis() - start;

      System.out.println(end);
      tot += end;
    }
    return tot / times;
  }
}
