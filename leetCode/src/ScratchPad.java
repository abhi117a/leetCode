import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScratchPad {

  public static void main(String args[]) {

    String str = "abXXXbba";

    System.out.println(str.substring(2, 5));
    System.out.println(9 / 2);
    System.out.println("String leng");
    System.out.println(str.length());

    System.out.println(16 % 10);
    System.out.println(16 / 10);

    String at = "ab.c.d.e";
    String k = at.replaceAll("\\.", "");
    System.out.println(k);

    String[] months = {
      "January",
      "February",
      "March",
      "April",
      "May",
      "June",
      "July",
      "August",
      "September",
      "October",
      "December"
    };
    Arrays.sort(months, (a, b) -> -1 * (a.length() - b.length()));

    for (String x : months) {
      System.out.println(x);
    }
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    List<Integer> li1 = new ArrayList();
    li1.add(1);
    li1.add(2);
    List<Integer> li2 = new ArrayList<>();
    li2.add(5);
    li2.add(6);
    List<Integer> li3 = new ArrayList<>();
    li3.add(90);
    li3.add(1090);
    lists.add((ArrayList<Integer>) li1);
    lists.add((ArrayList<Integer>) li2);
    lists.add((ArrayList<Integer>) li3);

    lists.stream().flatMap(ls -> ls.stream()).forEach(System.out::println);

    String st = "1233xxxxx";

    String ax[] = st.split("x", 2);

    for (String x : ax) {
      System.out.println(x);
    }

    System.out.println("Testing math");
    System.out.println(10 / 2 * (2));

    String s = "   -42";
    s = s.trim();
    System.out.println(s);

    String k1 = "a1 9 2 3 1";

    String kx[] = k1.split(" ");
    for (String x : kx) {
      System.out.println(x);
    }
    Character.isDigit(s.charAt(1));
    Character.isLetterOrDigit(s.charAt(1));

    System.out.println(54 % 18);

    String s1 = "hello";

    System.out.println(s1.substring(1)); // All Characters after one
    System.out.println(s1.substring(0, 1)); // Just the first character

    System.out.println(10 + 'k' - '0');
    // 1174

    System.out.println(1174 / 60 / 10);
    System.out.println(1174 / 60 % 10);
    System.out.println(1174 % 60 / 10);
    System.out.println(1174 % 60 % 10);

    System.out.println(6 % 3);
    System.out.println(Double.MIN_VALUE);

    Boolean flag = true;
    boolean flag1 = true;

    if (flag == flag1) {
      System.out.println("HAHA");
    }
  }
}
