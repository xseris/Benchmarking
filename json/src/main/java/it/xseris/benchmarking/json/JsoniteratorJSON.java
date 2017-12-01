package it.xseris.benchmarking.json;

import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JsoniteratorJSON {

  public long runSer(int times) throws IOException {
    long tot = 0;
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

  public long runDeser(int times) throws IOException {
    long tot = 0;
    ClassLoader classLoader = JsoniteratorJSON.class.getClassLoader();

    for (int i = 0; i < times; i++) {
      File file = new File(classLoader.getResource("pojo.json").getFile());

      long start = System.currentTimeMillis();
      byte[] encoded = Files.readAllBytes(file.toPath());
      JsonIterator.deserialize(encoded, MostComplexPojo.class);
      long end = System.currentTimeMillis() - start;

      System.out.println(end);
      tot += end;
    }
    return tot / times;
  }
}
