package com.pritesh;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

import java.util.List;

public class DataTableSteps {
  @Given("^We have below list of students$")
  public void we_have_below_list_of_students(DataTable arg1) {
    List<Student> students = arg1.asList(Student.class);

    System.out.println("--- Passing Data Table Steps ---");
    for (Student s : students) {
      s.printStudent();
    }
  }
}
