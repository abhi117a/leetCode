import java.util.ArrayList;
import java.util.List;

public class UsingArrayList {

  public static void main(String args[]) {

    List<Employees> employees = new ArrayList<>();
    employees.add(new Employees("abhi", "se", "123"));
    employees.add(new Employees("jay", "hr", "23"));
    employees.add(new Employees("jon", "IT", "56"));
    employees.add(new Employees("fox", "ee", "99"));

    employees.forEach(x -> System.out.println(x));

    System.out.println(employees.get(1).getJob());
  }
}
