package lambdaStreamPractice;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String args[]) {
    Students student1 =
        new Students(
            "Jayesh",
            20,
            new Address("12399"),
            Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

    Students student2 =
        new Students(
            "Khyati",
            20,
            new Address("1235"),
            Arrays.asList(
                new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

    Students student3 =
        new Students(
            "Jason",
            20,
            new Address("1236"),
            Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

    List<Students> studentsList = Arrays.asList(student1, student2, student3);

    ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
    ArrayList<String> singleList = new ArrayList<String>();
    singleList.add("hello");
    singleList.add("world");
    listOLists.add(singleList);

    ArrayList<String> anotherList = new ArrayList<String>();
    anotherList.add("this is another list");
    listOLists.add(anotherList);

    Students default1 =
        new Students("test", 00, new Address("testAdd"), Arrays.asList(new MobileNumber("test")));

    studentsList.stream()
        .filter(students -> students.getName().startsWith("J"))
        .findAny()
        .orElse(default1);
    String nameFindAny =
        studentsList.stream()
            .map(students -> students.getName())
            .filter(name -> name.startsWith("J"))
            .findAny()
            .orElse("Test");
    String nameFindAll =
        studentsList.stream()
            .map(students -> students.getName())
            .filter(name -> name.startsWith("J"))
            .findFirst()
            .orElse("Test");

    System.out.println("Find Any:" + nameFindAny);
    System.out.println("Find First:" + nameFindAll);

    listOLists.stream().forEach(System.out::println);
    listOLists.stream().flatMap(ls -> ls.stream()).forEach(System.out::println);

    /**
     * *************************************************** Get student with exact match name
     * "jayesh" ***************************************************
     */
    studentsList.stream()
        .map(students -> students.getName())
        .filter(s -> s.equalsIgnoreCase("Jayesh"))
        .peek(System.out::println)
        .count();

    System.out.println("------------");
    /**
     * *************************************************** Get student with matching address "1235"
     * ***************************************************
     */
    Optional<Students> stud =
        studentsList.stream()
            .filter(students -> students.getAddress().getZipcode().equalsIgnoreCase("1235"))
            .findFirst();

    System.out.println(stud.isPresent() ? stud.get().getName() : "No value found");

    System.out.println("------------");

    studentsList.stream()
        .filter(students -> students.getAddress().getZipcode().equalsIgnoreCase("1235"))
        .peek(System.out::println)
        .count();

    /**
     * *************************************************** Get all student having mobile numbers
     * 3333. ***************************************************
     */
    System.out.println("---------*---");

    studentsList =
        studentsList.stream()
            .filter(
                students ->
                    students.getMobileNumbers().stream()
                        .anyMatch(x -> Objects.equals(x.getNumber(), "3333")))
            .collect(Collectors.toList());
    System.out.println("**************");
    studentsList.stream().forEach(System.out::println);
    System.out.println("**************");

    System.out.println("Last method");

    studentsList.stream()
        .flatMap(students -> students.getMobileNumbers().stream())
        .filter(mobileNumber -> mobileNumber.getNumber().equalsIgnoreCase("3333"))
        .anyMatch(x -> Objects.equals(x.getNumber(), "3333"));

    /**
     * *************************************************** Get all student having mobile number 1233
     * and 1234 ***************************************************
     */
    System.out.println("Get a student having both mobile number 1233 and 1234");

    List<Students> stdd =
        studentsList.stream()
            .filter(
                students ->
                    students.getMobileNumbers().stream()
                        .allMatch(
                            x ->
                                Objects.equals(x.getNumber(), "1233")
                                    || Objects.equals(x.getNumber(), "1234")))
            .collect(Collectors.toList());

    stdd.stream().forEach(System.out::println);

    List<Students> stud3 =
        studentsList.stream()
            .filter(
                student ->
                    student.getMobileNumbers().stream()
                        .allMatch(
                            x ->
                                Objects.equals(x.getNumber(), "1233")
                                    || Objects.equals(x.getNumber(), "1234")))
            .collect(Collectors.toList());

    String result4 =
        stud3.stream().map(std -> std.getName()).collect(Collectors.joining(",", "[", "]"));
    System.out.println(result4);
    System.out.println("--------------------");

    /**
     * *************************************************** Create a List<Student> from the
     * List<TempStudent> ***************************************************
     */
    TempStudent tmpStud1 =
        new TempStudent(
            "Jayesh1",
            201,
            new Address("12341"),
            Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

    TempStudent tmpStud2 =
        new TempStudent(
            "Khyati1",
            202,
            new Address("12351"),
            Arrays.asList(
                new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

    List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

    List<Students> newStudent =
        tmpStudents.stream()
            .map(
                tempStudent ->
                    new Students(
                        tempStudent.name,
                        tempStudent.age,
                        tempStudent.address,
                        tempStudent.mobileNumbers))
            .collect(Collectors.toList());

    /**
     * *************************************************** Convert List<Student> to List<String> of
     * student name ***************************************************
     */
    List<String> names = studentsList.stream().map(Students::getName).collect(Collectors.toList());
    System.out.println("Names Printing");
    names.stream().forEach(System.out::println);
  }
}
