package ElementsOfProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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

  // LeetCode #66. Plus One  EPI 5.2
  private int[] incrementAnArrayBy1(int arr[]) {

    int j = arr.length - 1;
    StringBuilder sb = new StringBuilder();
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] < 9) {
        arr[i] += 1;
        return arr;
      } else {
        arr[i] = 0;
      }
    }
    int res[] = new int[arr.length + 1];
    res[0] = 1;
    return res;
  }

  // EPI 5.3 // Not a correct solution

  private List<Integer> multiplyTwoArbitartyArray(int a[], int b[]) {

    List<Integer> result = new ArrayList<>();
    int i = a.length - 1;
    int j = b.length - 1;
    int carry = 0;
    int sum = 0;
    while (i >= 0 || j >= 0) {
      sum = carry;
      int x = i >= 0 ? a[i] : 1;
      int y = j >= 0 ? b[j] : 1;
      i--;
      j--;
      sum += x * y;
      carry = sum / 10;
      result.add(sum % 10);
    }
    Collections.reverse(result);
    return result;
  }

  // EPI 5.4 Advancing through Array
  private boolean advancingThroughArray(int a[]) {
    // At any index i we can only advance till "i+A[i]" steps
    // At any point i which is less than lastIndex if can only reach i then we cannot reach
    // lastIndex that's why i <= fPoint
    int lastIndex = a.length - 1;
    int fPoint = 0;
    for (int i = 0; i <= fPoint && fPoint < lastIndex; i++) {
      fPoint = Math.max(fPoint, i + a[i]);
    }

    return fPoint >= lastIndex;
  }

  public static void main(String[] args) {
    String input = "Do or do not, there is no try.";
    Chapter6_Arrays c6 = new Chapter6_Arrays();
    int[] a = {1, 2};
    int[] b = {3, 3, 2};
    System.out.println(c6.multiplyTwoArbitartyArray(a, b));

    // System.out.println(c6.reversewords(input));
  }
}
