package ElementsOfProgramming;

import java.util.HashMap;

public class Chapter6_Arrays {

  // Find the first non repeated character

  private int findFirstNonRepeatedCharacter(String s) {

    HashMap<Character, Integer> hm = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      int tmp = hm.getOrDefault(s.charAt(i), 0);
      tmp = tmp > 0 ? -1 : 1;
    }

    for (int i = 0; i < s.length(); i++) {
      if (hm.get(s.charAt(i)) == 1) {
        return i;
      }
    }
    return -1;
  }

  /// Remove Specified CHaracter
  private String removeSpecifiedCharacter(String s, String r) {

    HashMap<Character, Integer> hm = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      int tmp = hm.getOrDefault(s.charAt(i), 0);
      hm.put(s.charAt(i), ++tmp);
    }
    for (int i = 0; i < r.length(); i++) {
      if (hm.containsKey(r.charAt(i))) {
        hm.remove(r.charAt(i));
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (hm.containsKey(s.charAt(i))) {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }

  // Reverse Words
  // transform the string "Do or do not, there is no try." to "try. no is there not, do or Do"

  private String reversewords(String s) {

    String arr[] = s.split(" ");

    StringBuilder sb = new StringBuilder();
    for (int i = arr.length - 1; i >= 0; i--) {
      sb.append(arr[i] + " ");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String input = "Do or do not, there is no try.";
    Chapter6_Arrays c6 = new Chapter6_Arrays();

    // System.out.println(c6.reversewords(input));
  }
}
