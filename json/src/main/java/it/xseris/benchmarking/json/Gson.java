package it.xseris.benchmarking.json;

import com.google.gson.GsonBuilder;

import java.io.IOException;

public class Gson {

  public long run(int times) throws IOException {
    long tot = 0;
    ClassLoader classLoader = Gson.class.getClassLoader();
    MostComplexPojo pojo = new MostComplexPojo();
    for (int i = 0; i < times; i++) {
      com.google.gson.Gson gson = new GsonBuilder()
          .registerTypeAdapter(MostComplexPojo.class, new MostComplexPojo()).create();

      long start = System.currentTimeMillis();
      gson.toJson(pojo);
      long end = System.currentTimeMillis() - start;

      System.out.println(end);
      tot += end;
    }
    return tot / times;
  }
}
