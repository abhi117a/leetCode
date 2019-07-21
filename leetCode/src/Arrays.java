import java.util.*;

public class Arrays {

  private void DutchNationalFlag(int[] flag) {
    int[] bank = new int[3];
    java.util.Arrays.fill(bank, 0);
    for (int i = 0; i < flag.length; i++) {
      if (flag[i] == 0) {
        bank[0]++;
      }
      if (flag[i] == 1) {
        bank[1]++;
      }
      if (flag[i] == 2) {
        bank[2]++;
      }
    }

    for (int i = 0; i < bank.length; i++) {

      for (int j = 0; j < bank[i]; j++) {
        System.out.println(i);
      }
    }
  }

  // Find maximum average subarray of k length

  private void maxSubarrayforRangeK(int arr[], int k) {

    int csum[] = new int[arr.length];
    csum[0] = 0;

    for (int i = 1; i < arr.length; i++) {
      csum[i] = csum[i - 1] + arr[i];
    }
    int maxSum = csum[k - 1];

    for (int i = k; i < arr.length; i++) {
      int tmpMax = csum[i] - csum[i - k];
      maxSum = tmpMax > maxSum ? tmpMax : maxSum;
    }
  }

  // Buy Sell Stock once

  private void buySellStockOnce(int arr[]) {
    int buy = Integer.MAX_VALUE;
    int sell = Integer.MIN_VALUE;
    int trans = 0;
    for (int x : arr) {
      if (buy > x) {
        buy = x;
      } else if (sell < x) {
        sell = x;
        trans = trans > sell - buy ? trans : sell - buy;
      }
    }
  }

  private void buySellStockMultiple(int arr[]) {
    int buy = Integer.MAX_VALUE;
    int sell = Integer.MIN_VALUE;
    int trans = 0;

    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] < arr[i + 1]) {
        trans += arr[i + 1] - arr[i];
      }
    }
    System.out.println(trans);
  }

  private boolean powerOf2(int n) {
    if (n == 0) {
      return false;
    }
    return ((n & n - 1) == 0);
  }

  private boolean robotOrigin(String moves) {

    int x = 0;
    int y = 0;
    for (int i = 0; i < moves.length(); i++) {
      if (moves.charAt(i) == 'U') {
        y++;
      } else if (moves.charAt(i) == 'D') {
        y--;
      } else if (moves.charAt(i) == 'L') {
        x++;
      } else if (moves.charAt(i) == 'R') {
        x--;
      }
    }
    return x == 0 && y == 0;
  }

  // Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate
  // (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i,
  // 0).
  // Find two lines, which together with x-axis forms a container, such that the container contains
  // the most water.

  private void waterLevel(int arr[]) {

    int start = 0;
    int end = arr.length - 1;
    int globMax = Integer.MIN_VALUE;
    while (start < end) {
      if (arr[start] > arr[end]) {
        int tmpMax = (end - start) * arr[end];
        globMax = globMax < tmpMax ? tmpMax : globMax;
        end--;
      } else if (arr[start] <= arr[end]) {
        int tmpMax = (end - start) * arr[start];
        globMax = globMax < tmpMax ? tmpMax : globMax;
        start++;
      }
    }
    System.out.println(globMax + "Max Water Level");
  }

  private void productofEveryElemetExceptSelf(int arr[]) {
    int L[] = new int[arr.length];
    int R[] = new int[arr.length];

    L[0] = 1;
    R[arr.length - 1] = 1;
    for (int i = 1; i < arr.length; i++) {
      L[i] = L[i - 1] * arr[i - 1];
    }
    for (int i = arr.length - 2; i >= 0; i--) {
      R[i] = R[i + 1] * arr[i + 1];
    }

    for (int i = 0; i < arr.length; i++) {
      L[i] = L[i] * R[i];
      System.out.println(L[i]);
    }
  }
  // Given a sorted array nums, remove the duplicates in-place such that each element appear only
  // once and return the new length.
  //
  // Do not allocate extra space for another array, you must do this by modifying the input array
  // in-place with O(1) extra memory.
  public int removeDuplicates(int[] nums) {
    int index = 1;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] != nums[i + 1]) {
        nums[index++] = nums[i + 1];
      }
    }
    return index;
  }
  // Given an array of numbers and an index i, return the index of the nearest larger number of the
  // number at index i, where distance is measured in array indices.
  private void findNearestLargestNumber(int arr[], int index) {

    int left = index - 1;
    int right = index + 1;
    int maxIndex = 0;
    int max = Integer.MIN_VALUE;
    while (left >= 0 || right < arr.length) {
      if ((left >= 0 && arr[index] < arr[left])
          && (right < arr.length && arr[right] > arr[index])) {
        if (arr[left] > arr[right]) {
          maxIndex = left;
        } else {
          maxIndex = right;
        }
        System.out.println(maxIndex);
        return;
      } else if (left >= 0 && arr[index] < arr[left] && right >= arr.length) {
        maxIndex = left;
        System.out.println(maxIndex);
        return;
      } else if (right < arr.length && arr[right] > arr[index] && left < 0) {
        maxIndex = right;
        System.out.println(maxIndex);
        return;
      }
      left--;
      right++;
    }
  }

  private List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

    java.util.Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          List<Integer> tmp = new ArrayList<>();
          tmp.add(nums[i]);
          tmp.add(nums[left]);
          tmp.add(nums[right]);
          if (!res.contains(tmp)) {
            res.add(tmp);
          }

          int leftVal = nums[left];
          while (left < right && leftVal == nums[left]) {
            ++left;
          }
          int rightVal = nums[right];
          while (left < right && rightVal == nums[right]) {
            --right;
          }
        }

        if (sum > 0) {
          right--;
        } else if (sum < 0) {
          left++;
        }
      }
    }
    return res;
  }

  private int threeSumClosest(int[] nums, int target) {

    java.util.Arrays.sort(nums);

    int diff = 0;
    int result = 0;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        diff = Math.abs(target - sum);
        if (sum == target) {
          return sum;
        }
        if (diff < min) {
          min = diff;
          result = sum;
        }
        if (sum >= target) {
          --right;
        }
        if (sum < target) {
          ++left;
        }
      }
    }
    return result;
  }

  public int trapRainWater(int[] height) {
    int left = 0;
    int leftMax = 0;
    int right = height.length - 1;
    int rightMax = 0;
    int ans = 0;
    while (left < right) {

      if (height[left] < height[right]) {

        if (height[left] > leftMax) {
          leftMax = height[left];
        } else {
          ans += leftMax - height[left];
        }
        left++;

      } else {
        if (height[right] > rightMax) {
          rightMax = height[right];
        } else {
          ans += rightMax - height[right];
        }
        right--;
      }
    }
    return ans;
  }

  private void findMaximumIntervalOverlap(int enter[], int[] exit) {

    int n = enter.length;
    int time = enter[0];
    int i = 1;
    int j = 0;
    int guestinn = 1;
    int max_guest = 1;

    while (i < n && j < n) {

      if (enter[i] <= exit[j]) {
        guestinn++;

        if (max_guest < guestinn) {
          max_guest = guestinn;
          time = enter[i];
        }
        i++;
      } else {
        guestinn--;
        j++;
      }
    }
  }
  /// Merge intervals Leetcode 56
  private void mergeIntervals(int[][] intervals) {

    Stack<int[]> st = new Stack<>();

    java.util.Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    st.push(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      int[] curr = intervals[i];
      int[] top = st.peek();
      if (top[0] < curr[0]) {
        st.push(curr);
      } else if (top[1] < curr[1]) {
        top[1] = curr[1];
        st.pop();
        st.push(top);
      }
    }
  }

  private boolean containsDuplicate(int[] nums) {

    if (nums.length < 1) {
      return false;
    }
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {

      int tmp = hm.getOrDefault(nums[i], 0);
      if (tmp > 1) {
        return true;
      }
      hm.put(nums[i], ++tmp);
      if (hm.get(nums[i]) > 1) {
        return true;
      }
    }
    return false;
  }

  public int findPeakElement(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {

      int mid = left + (right - left) / 2;

      if (nums[mid] < nums[mid + 1]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
  // LeetCode #66. Plus One
  private int[] plusOne(int digits[]) {
    int carry = 0;
    for (int i = digits.length - 1; i >= 0; i--) {

      if (digits[i] < 9) {
        digits[i]++;
        return digits;

      } else {
        digits[i] = 0;
      }
    }

    int[] res = new int[digits.length + 1];
    res[0] = 1;
    return res;
  }

  // Leetcode # 989. Add to Array-Form of Integer

  private List<Integer> addToArrayForm(int[] A, int K) {

    StringBuilder sb = new StringBuilder();
    for (int x : A) {
      sb.append(x);
    }
    String inp = sb.toString();
    int res = Integer.parseInt(inp);
    res = res + K;
    List<Integer> result = new ArrayList<>();
    Stack<Integer> st = new Stack<>();
    while (res > 0) {
      int tmp = res % 10;
      st.push(tmp);
      res = res / 10;
    }

    while (!st.isEmpty()) {
      int tmp = st.pop();
      result.add(tmp);
    }

    return result;
  }

  public int[][] merge(int[][] intervals) {

    java.util.Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    Stack<int[]> st = new Stack<>();

    st.push(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int curr[] = intervals[i];
      int sta[] = st.peek();
      if (curr[0] > sta[1]) {
        st.push(curr);
      } else {
        if (curr[1] > sta[1]) {
          sta[1] = curr[1];
          st.pop();
          st.push(curr);
        }
      }
    }

    return null;
  }
  // LeetCode  256. Paint House NOT a Correct solution
  private int minCost(int[][] costs) {
    int sum = 0;
    for (int[] x : costs) {
      sum += minFunc(x[0], x[1], x[2]);
    }
    return sum;
  }

  private int minFunc(int a, int b, int c) {

    if (a > b && a > c) {
      return a;
    } else if (b > c && b > a) {
      return b;
    } else return c;
  }

  // 881. Boats to Save People

  private int numRescueBoats(int[] people, int limit) {

    java.util.Arrays.sort(people);

    int left = 0;
    int right = people.length - 1;
    int total = 0;
    while (left <= right) {
      if (people[left] + people[right] <= limit) {
        left++;
        right--;
      } else {
        right--;
      }
      total++;
    }
    return total;
  }

  // 485. Max Consecutive Ones

  private int maxConsecutives1s(int[] arr) {

    int left = 0;
    int right = 0;
    int max = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        left = i + 1;
        right = i + 1;
      } else {
        right++;
        max = max > right - left ? max : right - left;
      }
    }
    return max;
  }

  private int countPrimes(int n) {
    int answer = 0;
    boolean[] prime = new boolean[n + 1];
    java.util.Arrays.fill(prime, true);

    for (int p = 2; p * p <= n; p++) {
      if (prime[p]) {
        for (int i = p * p; i <= n; i += p) {
          prime[i] = false;
        }
      }
    }
    for (int i = 2; i <= n; i++) {
      answer += prime[i] == true ? 1 : 0;
    }
    return answer;
  }

  // LeetCode 941. Valid Mountain Array

  private boolean isHappy(int n) {
    HashSet<Integer> hs = new HashSet<>();
    while (n != 1) {
      int sum = 0;
      int current = n;
      while (current != 0) {
        sum += (current % 10) * (current % 10);
        current = current / 10;
      }
      if (hs.contains(sum)) {
        return false;
      } else {
        hs.add(sum);
        n = sum;
      }
    }
    return true;
  }

  private boolean validMountainArray(int[] A) {

    if (A.length < 3) {
      return false;
    }

    int i = 0;
    while (i < A.length && i + 1 < A.length && A[i] < A[i + 1]) {
      i++;
    }
    if (i == 0 || i + 1 >= A.length) {
      return false;
    }
    while (i < A.length && i + 1 < A.length) {
      if (A[i] <= A[i++ + 1]) {
        return false;
      }
    }
    return true;
  }

  // LeetCode 202. Happy Number

  private int addDigits(int num) {

    while (num > 9) {
      int sum = 0;
      int current = num;
      while (current != 0) {
        sum += current % 10;
        current = current / 10;
      }
      num = sum;
    }
    return num;
  }

  // Leetcode 263. Ugly Number
  private boolean uglyNumber(int num) {

    if (num == 0) {
      return false;
    }

    while (num % 2 == 0) {
      num = num / 2;
    }
    while (num % 3 == 0) {
      num = num / 3;
    }
    while (num % 5 == 0) {
      num = num / 5;
    }
    if (num != 1) {
      return false;
    } else {
      return true;
    }
  }

  // LeetCode 1085. Sum of Digits in the Minimum Number

  private int sumOfDigits(int[] A) {

    int max = Integer.MAX_VALUE;
    for (int x : A) {
      max = max < x ? max : x;
    }

    if (max < 9) {
      if (max % 2 == 0) {
        return 1;
      } else return 0;
    }

    while (max > 9) {
      int sum = 0;
      int curr = max;
      while (curr != 0) {
        sum += curr % 10;
        curr = curr / 10;
      }
      if (sum % 2 == 0) {
        return 1;
      } else return 0;
    }
    return max;
  }

  public int thirdMax(int[] nums) {

    double max1 = Double.MIN_VALUE;
    double max2 = Double.MIN_VALUE;
    double max3 = Double.MIN_VALUE;
    for (int x : nums) {
      if (max1 < x) {
        max3 = max2;
        max2 = max1;
        max1 = x;
      } else if (max2 < x && x != max1) {
        max3 = max2;
        max2 = x;
      } else if (max3 < x && x != max2 && x != max1) {
        max3 = x;
      }
    }

    if (nums.length > 2 && max3 != Double.MIN_VALUE) {
      return (int) max3;
    } else {
      return (int) max1;
    }
  }

  private int[] sortArrayByParity(int[] A) {

    int i = 0;
    int j = A.length - 1;
    while (i < j) {
      if (A[i] % 2 == 0) {
        i++;
      } else {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
        j--;
      }
    }
    return A;
  }

  public static void main(String args[]) {
    Arrays arr = new Arrays();
    int[] aer = {2, 0, 2, 1, 1, 0};
    int[] stock = {7, 1, 5, 3, 6, 4};
    // arr.buySellStockMultiple(stock);

    // System.out.println(arr.powerOf2(4));
    // [0,0,1,1,2,2]
    // arr.DutchNationalFlag(aer);
    int[] waterlev = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    // arr.waterLevel(waterlev);
    int value[] = {1, 2, 3, 4};
    // arr.productofEveryElemetExceptSelf(value);
    int large[] = {4, 1, 3, 5, 6};
    System.out.println("Largest Number at index");
    // arr.findNearestLargestNumber(large, 0);

    int[][] val = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    System.out.println(arr.merge(val));
    int[] plusOne = {4, 3, 2, 9};
    // arr.plusOne(plusOne);
    int[] people = {3, 5, 3, 4};
    System.out.println(arr.numRescueBoats(people, 5));
  }
}
