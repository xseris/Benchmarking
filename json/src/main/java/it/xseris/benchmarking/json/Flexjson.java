package it.xseris.benchmarking.json;

import java.io.IOException;

import flexjson.JSONSerializer;

public class Flexjson {

  public long run(int times) throws IOException {
    long tot = 0;
    ClassLoader classLoader = Flexjson.class.getClassLoader();
    MostComplexPojo pojo = new MostComplexPojo();
    JSONSerializer serializer = new JSONSerializer();
    for (int i = 0; i < times; i++) {

      long start = System.currentTimeMillis();
      serializer.serialize(pojo);
      long end = System.currentTimeMillis() - start;

      System.out.println(end);
      tot += end;
    }
    return tot / times;
  }
}
