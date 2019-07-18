package javaFeaturesCheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employees {

  private String name;

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  private int id;

  public Employees(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public static void main(String args[]) {

    Employees jon = new Employees("Jon", 10);
    Employees abhi = new Employees("Abhi", 13);
    Employees akan = new Employees("Kan", 9);
    Employees jay = new Employees("Jay", 76);
    Employees fox = new Employees("Fox", -12);

    List<Employees> employeesList = new ArrayList<>();
    employeesList.add(jon);
    employeesList.add(abhi);
    employeesList.add(akan);
    employeesList.add(jay);
    employeesList.add(fox);

    Collections.sort(
        employeesList,
        new Comparator<Employees>() {
          @Override
          public int compare(Employees employee1, Employees employee2) {

            return employee1.getName().compareTo(employee2.getName());
          }
        });

    // Lambda
    Collections.sort(employeesList, (emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));

    for (Employees ee : employeesList) {
      System.out.println(ee.getName());
    }

    List<String> namer =
        employeesList.stream()
            .map(variableofEmployeeType -> variableofEmployeeType.getName().toUpperCase())
            .filter(namee -> namee.length() > 3)
            .collect(Collectors.toList());

    System.out.println("********Namer**********");
    namer.stream().forEach(System.out::println);

    System.out.println("********EmployeeList**********");
    employeesList =
        employeesList.stream()
            .filter(employees -> employees.getName().length() > 3)
            .collect(Collectors.toList());

    employeesList.stream().forEach(System.out::println);
  }
}
