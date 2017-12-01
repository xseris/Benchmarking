package it.xseris.benchmarking.json;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GsonJSON {

  public long runSer(int times) throws IOException {
    long tot = 0;
    MostComplexPojo pojo = new MostComplexPojo();
    for (int i = 0; i < times; i++) {
      Gson gson = new Gson();

      long start = System.currentTimeMillis();
      gson.toJson(pojo);
      long end = System.currentTimeMillis() - start;

      System.out.println(end);
      tot += end;
    }
    return tot / times;
  }

  public long runDeser(int times) throws IOException {
    long tot = 0;
    ClassLoader classLoader = GsonJSON.class.getClassLoader();
    Gson gson = new Gson();

    for (int i = 0; i < times; i++) {
      File file = new File(classLoader.getResource("pojo.json").getFile());
      Reader in = new FileReader(file);

      long start = System.currentTimeMillis();
      gson.fromJson(in, MostComplexPojo.class);
      long end = System.currentTimeMillis() - start;

      System.out.println(end);
      in.close();
      tot += end;
    }
    return tot / times;
  }
}
