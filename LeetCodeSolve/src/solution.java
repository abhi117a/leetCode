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
  ////// Multiples of 5 and 3 /////
  private List<String> fizzBuzz(int n) {
    int count = 1;
    List<String> fin = new ArrayList<>();
    while (count <= n) {
      if (count % 5 == 0 && count % 3 == 0) {
        fin.add("FizzBuzz");
        count++;
      } else if (count % 5 == 0) {
        fin.add("Buzz");
        count++;
      } else if (count % 3 == 0) {
        fin.add("Fizz");
        count++;
      } else {
        fin.add(Integer.toString(count));
        count++;
      }
    }
    System.out.print(fin);
    return fin;
  }

  //// Compressed String Iterator////

  ///// LRU Cache //////////
  ///// LRU Cache //////////

  //// Reverse a string/array inplace

  private void reverse(char[] arr) {
    int start = 0;
    int end = arr.length - 1;

    while (start < end) {
      char temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }
  }

  private void reverseSentence(char[] message) {

    int start = 0;
    int end = message.length - 1;
    char[] reversedMessage = helper(start, end, message);

    int spaceFinder = 0;
    for (int i = 0; i <= reversedMessage.length; i++) {
      if (message[i] == ' ' || i == message.length) {
        helper(spaceFinder, i, reversedMessage);
        spaceFinder += i + 1;
      }
    }
  }

  private char[] helper(int start, int end, char[] message) {
    while (start < end) {
      char temp = message[start];
      message[start] = message[end];
      message[end] = message[start];
      start++;
      end--;
    }
    return message;
  }
  /// Subarray with given sum ///

  private void subArraySum(int[] arr, int target) {
    int GlobSum = 0;
    int lenSubArray = 0;
    int start = -1;
    int end = -1;
    for (int i = 0; i < arr.length; i++) {

      if (GlobSum < target) {
        if (start != -1) {
          end = i;
        } else {
          start = i;
        }
        GlobSum += arr[i];
        lenSubArray++;
      } else if (GlobSum == target) {
        System.out.print(
            "Target value found length of subArray: "
                + lenSubArray
                + "Start Index: "
                + start
                + "End index: "
                + end);
        return;
      } else if (GlobSum > target) {
        i--;
        GlobSum = 0;
        lenSubArray = 0;
        start = -1;
        end = -1;
      }
    }
  }

  /// Sort Array of 0, 1 and 2///

  private void sortArray(int[] arr) {

    int bank[] = new int[3];

    for (int x : arr) {
      if (x == 0) {
        bank[0]++;
      } else if (x == 1) {
        bank[1]++;
      } else {
        bank[2]++;
      }
    }
    int counter = 0;
    for (int i = 0;
        i < bank.length;
        i++) { // though 2 loops but the first loop is of constant i.e. 3 so it will be 3N == N
      for (int j = 0; j < bank[i]; j++) {
        System.out.print(i);
        arr[counter] = i;
      }
    }
  }

  public static void main(String[] args) {
    int test[] = {2, 7, 11, 15, 32};
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
    // ts.mergeSorted(nums1, 3, nums2, 3);

    // ts.fizzBuzz(15);

    char[] arr = {'H', 'E', 'L', 'L', 'O'};
    // ts.reverse(arr);

    int target[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    // ts.subArraySum(target, 15);

    int val[] = {2, 2, 2, 1, 1, 1, 0, 0, 0, 1};
    ts.sortArray(val);
  }
}
