package com.pritesh;

public class Student {
  private String name;
  private String address;
  private int id;

  public Student(String name, int id, String address) {
    this.name = name;
    this.id = id;
    this.address = address;
  }

  public void printStudent() {
    System.out.println("\nStudent -> " + name + ", " + id + ", " + address);
  }
}
