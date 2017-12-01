package it.xseris.benchmarking.json;

import java.io.IOException;

public class Application {

  private static final int TIMES = 100;

  public static void main(String[] args) throws IOException {
    FlexJSON flexjson = new FlexJSON();
    GsonJSON gson = new GsonJSON();
    JacksonJSON jackson = new JacksonJSON();
    JsoniteratorJSON jsoniterator = new JsoniteratorJSON();
    GensonJSON genson = new GensonJSON();

    System.out.println("Flexjson serialization took: " + flexjson.runSer(TIMES));
    System.out.println("Gson serialization took: " + gson.runSer(TIMES));
    System.out.println("Jackson serialization took: " + jackson.runSer(TIMES));
    System.out.println("Jsoniterator serialization took: " + jsoniterator.runSer(TIMES));
    System.out.println("Gensonjson serialization took: " + genson.runSer(TIMES));

    System.out.println("Flexjson deserialization took: " + flexjson.runDeser(TIMES));
    System.out.println("Gson deserialization took: " + gson.runDeser(TIMES));
    System.out.println("Jackson deserialization took: " + jackson.runDeser(TIMES));
    System.out.println("Jsoniterator deserialization took: " + jsoniterator.runDeser(TIMES));
    System.out.println("Gensonjson deserialization took: " + genson.runDeser(TIMES));
  }
}
