package it.xseris.benchmarking.json;

import com.owlike.genson.Genson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GensonJSON {

  public long runSer(int times) throws IOException {
    long tot = 0;
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

  public long runDeser(int times) throws IOException {
    long tot = 0;
    ClassLoader classLoader = JsoniteratorJSON.class.getClassLoader();
    Genson genson = new Genson();
    for (int i = 0; i < times; i++) {
      File file = new File(classLoader.getResource("pojo.json").getFile());
      Reader in = new FileReader(file);

      long start = System.currentTimeMillis();
      genson.deserialize(in, MostComplexPojo.class);
      long end = System.currentTimeMillis() - start;

      System.out.println(end);
      in.close();
      tot += end;
    }
    return tot / times;
  }
}
