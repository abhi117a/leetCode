package javaFeaturesCheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Students {

  private int id;

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  private String name;

  public Students(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public static void main(String args[]) {
    Students ss = new Students(1, "abhi");
    Students ss1 = new Students(2, "jay");
    Students ss2 = new Students(-1, "koko");
    Students ss3 = new Students(100, "sude");
    Students ss4 = new Students(101, "opo");
    List<Students> studentsList = new ArrayList<>();
    studentsList.add(ss);
    studentsList.add(ss1);
    studentsList.add(ss2);
    studentsList.add(ss3);
    studentsList.add(ss4);

    Collections.sort(
        studentsList,
        new Comparator<Students>() {
          @Override
          public int compare(Students s1, Students s2) {
            return (s1.getId() > s2.getId()) ? -1 : s1.getId() < s2.getId() ? 1 : 0;
          }
        });

    Collections.sort(
        studentsList,
        (S1, S2) -> (S1.getId() < S2.getId()) ? -1 : (S1.getId() > S2.getId()) ? 1 : 0);

    studentsList.forEach(
        s1 -> {
          System.out.println(s1.getId());
        });

    studentsList.forEach(
        s1 -> {
          if (s1.getId() < 0) System.out.println(s1);
        });

    studentsList.stream().map(Students::getId).filter(s -> s < 0).forEach(System.out::println);

    studentsList.stream()
        .map(variableofStudentType -> variableofStudentType.getName().toUpperCase())
        .filter(s -> s.startsWith("K"))
        .sorted()
        .forEach(System.out::println);

    studentsList.stream()
        .map(variableOfStudent -> variableOfStudent.getId())
        .reduce((id1, id2) -> id1 < id2 ? id2 : id1)
        .ifPresent(System.out::println);
  }
}
