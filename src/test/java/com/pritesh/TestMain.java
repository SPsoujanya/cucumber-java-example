package com.pritesh;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestMain {
  public static void main(String args[]) {
    Path resourceDirectory = Paths.get("src", "test", "resources");
    System.out.println(resourceDirectory.toString());
  }
}
