package it.xseris.benchmarking.json;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class FlexJSON {

  public long runSer(int times) throws IOException {
    JSONSerializer serializer = new JSONSerializer();
    long tot = 0;
    MostComplexPojo pojo = new MostComplexPojo();
    for (int i = 0; i < times; i++) {

      long start = System.currentTimeMillis();
      serializer.serialize(pojo);
      long end = System.currentTimeMillis() - start;

      System.out.println(end);
      tot += end;
    }
    return tot / times;
  }

  public long runDeser(int times) throws IOException {
    long tot = 0;
    ClassLoader classLoader = FlexJSON.class.getClassLoader();
    JSONDeserializer<MostComplexPojo> deserializer = new JSONDeserializer<MostComplexPojo>();
    
    for (int i = 0; i < times; i++) {
      File file = new File(classLoader.getResource("pojo.json").getFile());
      Reader in = new FileReader(file);

      long start = System.currentTimeMillis();
      deserializer.deserialize(in);
      long end = System.currentTimeMillis() - start;

      System.out.println(end);
      in.close();
      tot += end;
    }
    return tot / times;
  }
}
