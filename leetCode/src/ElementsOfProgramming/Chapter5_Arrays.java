package ElementsOfProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Chapter5_Arrays {

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

  // EPI 5.5 Remove Duplicates from Sorted Array O(N) Time and O(1) Space

  private int[] removeDuplicate(int[] A) {
    int index = 1;
    for (int i = 0; i < A.length - 1; i++) {
      if (A[i] != A[i + 1]) {
        A[index++] = A[i + 1];
      }
    }
    return A;
  }

  // EPI 5.6 Buy and Sell Stock Once

  private int buySellStock(int[] A) {

    int maxProfit = Integer.MIN_VALUE;
    int minPrice = Integer.MAX_VALUE;

    for (int x : A) {
      minPrice = Math.min(minPrice, x);
      maxProfit = Math.max(maxProfit, x - minPrice);
    }
    return maxProfit;
  }

  // EPI 5.7 Buy and Sell Stock at most twice
  // Leetcode 123. Best Time to Buy and Sell Stock III

  private int buySellStockIII(int a[]) {

    List<Integer> frontMove = new ArrayList<>();
    int minPrice = Integer.MAX_VALUE;
    int maxProfit =
        0; // The maximum profit variable is common for both the loops because at the start of
    // second loop we need to maintain maxProfit and compare it with current val
    for (int i = 0; i < a.length; i++) {
      minPrice = Math.min(minPrice, a[i]);
      maxProfit = Math.max(maxProfit, a[i] - minPrice);
      frontMove.add(maxProfit);
    }

    int maxValue = Integer.MIN_VALUE;
    for (int i = a.length - 1; i > 0; i--) { // i>0 and not i>=0 because we are going till i-1
      maxValue = Math.max(maxValue, a[i]);
      maxProfit = Math.max(maxProfit, maxValue - a[i] + frontMove.get(i - 1));
    }

    return maxProfit;
  }

  // Some one's else code for above but I like the simplicity!!

  public int maxProfit(int[] prices) {
    int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
    int release1 = 0, release2 = 0;
    for (int i : prices) { // Assume we only have 0 money at first
      release2 = Math.max(release2, hold2 + i); // The maximum if we've just sold 2nd stock so far.
      hold2 = Math.max(hold2, release1 - i); // The maximum if we've just buy  2nd stock so far.
      release1 = Math.max(release1, hold1 + i); // The maximum if we've just sold 1nd stock so far.
      hold1 = Math.max(hold1, -i); // The maximum if we've just buy  1st stock so far.
    }
    return release2; /// Since release1 is initiated as 0, so release2 will always higher than
    // release1.
  }

  // EPI 5.8
  // Leetcode 280. Wiggle Sort

  private int[] wiggleSort(int[] nums) {

    for (int i = 1; i < nums.length; i++) {
      if ((i % 2 == 0 && nums[i - 1] < nums[i]) || (i % 2 != 0 && nums[i - 1] > nums[i])) {
        swap(nums, i - 1, i);
      }
    }
    return nums;
  }

  public void swap(int[] nums, int a, int b) {

    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }

  public static void main(String[] args) {
    String input = "Do or do not, there is no try.";
    Chapter5_Arrays c6 = new Chapter5_Arrays();
    int[] a = {1, 2};
    int[] b = {3, 3, 2};
    System.out.println(c6.multiplyTwoArbitartyArray(a, b));

    // System.out.println(c6.reversewords(input));
  }
}
