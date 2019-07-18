import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CtCI_Arrays_Strings {

  //// O(N)
  private void checkPermutation1(String str, String str1) {
    int[] charc = new int[256];

    if (str == null || str1 == null || (str.length() != str1.length())) {
      System.out.println("Not a perm");
      return;
    }

    for (int i = 0, j = 0; i < str.length(); i++) {
      charc[str.charAt(i)]++;
      charc[str1.charAt(i)]--;
      j++;
    }

    for (int x : charc) {
      if (x != 0) {
        System.out.println("Not a perm");
        return;
      }
    }
    System.out.println("Perm");
  }

  private void isUnique(String str) {

    int checker = 0;

    int val = str.charAt(0) - 'a';

    if ((checker & (1 << val)) > 1) {
      return;
    } else checker |= 1 << val;
  }

  private void oneWay(String str, String str1) {

    if (str.length() > str1.length()) {
      insert(str, str1);
    }
    if (str.length() == str1.length()) {
      replace(str, str1);
    }
    if (str.length() < str1.length()) {
      remove(str, str1);
    }
  }

  private void replace(String str, String str1) {}

  private void remove(String str, String str1) {}

  private void insert(String str, String str1) {
    int charc[] = new int[26];
    int counter = 0;
    for (int i = 0; i < str.length(); i++) {
      charc[(str.charAt(i)) - 'a']++;
    }
    for (int j = 0; j < str1.length(); j++) {
      charc[(str.charAt(j)) - 'a']--;
    }
    for (int x : charc) {
      if (counter > 1) {
        System.out.println("Not a one edit");
        return;
      }
      if (x != 0) {
        counter++;
      }
    }
    System.out.println("It is a one edit");
  }

  private void permutOfPalindrome(String str) {
    HashMap<Character, Integer> hmap = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if (hmap.containsKey(str.charAt(i))) {
        int val = hmap.get(str.charAt(i));
        val++;
        hmap.put(str.charAt(i), val);
      } else {
        hmap.put(str.charAt(i), 1);
      }
    }
    //// Iterating Map/////
    Iterator<Map.Entry<Character, Integer>> itr = hmap.entrySet().iterator();
    boolean flag = true;
    while (itr.hasNext()) {
      Map.Entry<Character, Integer> entry = itr.next();
      if (flag && entry.getValue() % 2 != 0) {
        flag = false;
      } else {
        System.out.println("False");
      }
    }
    if (flag == false && str.length() % 2 != 0) {
      System.out.println("False");
    } else if (flag == true && str.length() % 2 == 0) {
      System.out.println("True");
    }
  }

  public static void main(String args[]) {

    CtCI_Arrays_Strings ct = new CtCI_Arrays_Strings();
    ct.checkPermutation1("ba", "ab");
  }
}
