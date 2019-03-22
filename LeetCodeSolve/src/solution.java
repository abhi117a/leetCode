import java.util.*;

public class solution {

  //// Two Numbers//////

  private int[] addTwoSum(int[] nums, int target) {

    HashMap<Integer, Integer> hm = new HashMap<>();
    int[] out = new int[2];
    for (int i = 0; i < nums.length; i++) {

      hm.put(nums[i], i);
    }

    for (int j = 0; j < nums.length; j++) {
      int temp = target - nums[j];
      if (hm.containsKey(temp)) {
        out[0] = j;
        out[1] = hm.get(temp);
        return out;
      }
    }

    return null;
  }

  //////// Reverse a Integer////

  private void revInt(int x) {
    boolean flag = x < 0 ? true : false;
    x = flag == true ? x * (-1) : x * 1;
    String temp = Integer.toString(x);
    StringBuilder sb = new StringBuilder();
    for (int i = temp.length() - 1; i >= 0; i--) {
      if (i == temp.length() - 1 && temp.charAt(i) == 0) {
      } else {
        sb.append(temp.charAt(i));
      }
    }
    String k = sb.toString();
    int fin = Integer.parseInt(k);
    fin = flag == true ? fin * (-1) : fin * 1;
    System.out.print(fin);
  }

  private void revInt1(int x) {
    // There are few edge cases which are very Java Specific
    /*
    if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
    if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
    */
    int pop = 0;
    int rev = 0;
    while (x != 0) {
      pop = x % 10;
      x /= 10;
      rev = rev * 10 + pop;
    }
    System.out.print(rev);
  }

  private boolean ifIntPalindrome(int x) {

    String check = Integer.toString(x);
    for (int i = 0, j = check.length() - 1; i < check.length() / 2; i++) {
      if (check.charAt(i) != check.charAt(j)) {
        return false;
      }
      j--;
    }

    return true;
  }

  private Set noCopy(int nums[]) {
    HashSet<Integer> hs = new HashSet<>();
    for (int x : nums) {
      hs.add(x);
    }
    return hs;
  }

  public int removeDuplicates(int[] nums) {
    System.out.print(nums.length);
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    System.out.print(nums.length);
    return i + 1;
  }

  private void maxSumSubArray(int nums[]) {
    int Globmax = Integer.MIN_VALUE;
    int max = 0;

    for (int i = 0; i < nums.length; i++) {
      max += nums[i];

      if (max > Globmax) {
        Globmax = max;
      }
      if (max < 0) {
        max = 0;
      }
    }
    System.out.print(Globmax);
  }

  private void buySellStock(int nums[]) {
    int buy = Integer.MAX_VALUE;
    int sell = Integer.MIN_VALUE;
    boolean flag = false;
    int transaction = 0;

    for (int x : nums) {

      if (buy > x) {
        buy = x;
      } else if (x - buy > transaction) {
        transaction = x - buy;
      }
    }
    System.out.print(transaction);
  }

  //// Check Valid Paranthesis////

  private boolean validParantehis(String s) {

    Stack<Character> st = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '{') {
        st.push('{');
      }
      if (s.charAt(i) == '[') {
        st.push('[');
      }
      if (s.charAt(i) == '(') {
        st.push('(');
      }
      if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')') {
        if (st.isEmpty()) {
          System.out.print("False");
          return false;
        } else {
          char temp = st.pop();
          if ((temp == '{' && s.charAt(i) == '}')
              || (temp == '[' && s.charAt(i) == ']')
              || (temp == '(' && s.charAt(i) == ')')) {
          } else {
            System.out.print("False");
            return false;
          }
        }
      }
    }
    if (!st.isEmpty()) {
      System.out.print("Flase");
      return false;
    }
    System.out.print("True");
    return true;
  }

  /// Merge two Sorted Array///

  private void mergeSorted(int nums1[], int m, int nums2[], int n) {

    ArrayList<Integer> fin = new ArrayList<>();
    int point1 = 0;
    int point2 = 0;

    int len = nums1.length > nums2.length ? nums1.length : nums2.length;

    while (point1 < m || point2 < n) {
      if (point1 < m && point2 < n) {
        if (nums1[point1] <= nums2[point2]) {
          fin.add(nums1[point1++]);
        } else {
          fin.add(nums2[point2++]);
        }
      } else if (point1 < m && point2 >= n) {
        fin.add(nums1[point1++]);
      } else if (point1 >= m && point2 < n) {
        fin.add(nums2[point2++]);
      }
    }
    for (int x : fin) {
      System.out.print(" " + x);
    }
  }

  public static void main(String[] args) {
    int test[] = {2, 7, 11, 15};
    solution ts = new solution();
    // System.out.print(ts.addTwoSum(test, 9));
    // ts.revInt1(-123);
    // ts.ifIntPalindrome(1111);

    int nums[] = {2, 1, 2, 1, 0, 1, 2};
    // System.out.print(ts.noCopy(nums));
    // ts.removeDuplicates(nums);
    // ts.maxSumSubArray(nums);
    // ts.buySellStock(nums);
    // ts.validParantehis("([)]");
    int[] nums1 = {1, 2, 3};
    int[] nums2 = {2, 5, 6};
    ts.mergeSorted(nums1, 3, nums2, 3);
  }
}
