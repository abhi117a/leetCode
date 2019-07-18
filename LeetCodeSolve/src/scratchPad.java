import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class scratchPad {

  public void met1() {
    final String propertyName = "hello";
  }

  public void met2() {
    final String propertyName = "hello";
  }

  public static void main(String[] args) {

    String str = "Hello World How are you?";

    String[] str2 = str.split(" ");

    for (String x : str2) {
      System.out.println(x);
    }

    char[] str1 = str.toCharArray();
    for (char j : str1) {
      // System.out.println(j);
    }

    HashMap<Integer, ArrayList> hm = new HashMap<>();
    hm.put(1, new ArrayList());
    hm.get(1).add(2);
    hm.get(1).add(3);
    hm.put(2, new ArrayList());
    hm.get(2).add("abc");
    hm.get(2).add("xyz");

    Iterator<Map.Entry<Integer, ArrayList>> itr = hm.entrySet().iterator();

    while (itr.hasNext()) {
      Map.Entry<Integer, ArrayList> entry = itr.next();
      System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    }
  }
}
