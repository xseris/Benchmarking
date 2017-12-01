package it.xseris.benchmarking.json;

import java.io.IOException;

public class Application {

  private static final int TIMES = 100;

  public static void main(String[] args) throws IOException {
    // Flexjson flexjson = new Flexjson();
    // System.out.println("Flexjson took: " + flexjson.run(TIMES));
    // Gson gson = new Gson();
    // System.out.println("Gson took: " + gson.run(TIMES));
    // Jackson jackson = new Jackson();
    // System.out.println("Jackson took: " + jackson.run(TIMES));
    // Jsoniterator jsoniterator = new Jsoniterator();
    // System.out.println("Jsoniterator took: " + jsoniterator.run(TIMES));
    Gensonjson genson = new Gensonjson();
    System.out.println("Gensonjson took: " + genson.run(TIMES));
  }
}
