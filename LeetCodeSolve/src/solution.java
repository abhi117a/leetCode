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

  private void equilibrium(int arr[]) {

    int start = 1;
    int end = arr.length - 2;

    int startSum = arr[0];
    int endSum = arr[arr.length - 1];

    while (start <= end) {

      if (startSum == endSum) {
        System.out.print("Equilibrium: " + start);
        return;
      }

      if (startSum < endSum) {
        startSum += arr[start++];
      } else if (startSum > endSum) {
        endSum += arr[end--];
      }
    }
    System.out.print("No eqilibrium");
  }

  /// Leaders In An Array///

  private void learderinArray(int arr[]) {
    int valueCounter = 0;
    int result[] = new int[arr.length];

    for (int i = 0; i < arr.length - 1; i++) {

      if (arr[i] >= arr[i + 1]) {
        System.out.print(arr[i]);
      }
    }
    System.out.print(arr[arr.length - 1]);
  }

  /// Minimum Platform or Airport

  private void minPlatformNeeded(int arrival[], int departure[], int count) {

    int platform_needed = 0, maxPlatforms = 0;
    // Arrays.sort(arrival);
    // Arrays.sort(departure);
    int i = 0, j = 0;

    // Similar to merge in merge sort
    while (i < count && j < count) {
      if (arrival[i] < departure[j]) {
        platform_needed++;
        i++;
        if (platform_needed > maxPlatforms) maxPlatforms = platform_needed;
      } else {
        platform_needed--;
        j++;
      }
    }
    System.out.print(maxPlatforms);

    /*
    Arrays.sort(arrival);
    Arrays.sort(departure);

    int i = 0;
    int j = 0;
    int platformCount = 0;
    int globPlatform = 0;

    while (i < count && j < count) {

      if (arrival[i] < departure[j]) {
        platformCount++;
        System.out.print(platformCount);
        i++;
        if (globPlatform < platformCount) {
          globPlatform += platformCount;
        }
      } else {
        platformCount--;
        j++;
      }
    }
    System.out.println("Total Num: " + globPlatform);
    */
  }

  // Maximum of all subarrays//
  private void maximumSubArrayinEach(int[] arr, int n) {

    int counter = 0;
    int forCounter = n;

    while (forCounter < arr.length) {
      int val = 0;
      int ans = limitLoop(counter++, forCounter++, arr);
      System.out.print(ans);
    }
  }

  private int limitLoop(int start, int end, int[] arr) {
    int val = 0;
    for (int i = start; i <= end; i++) {
      val = Integer.max(arr[i], val);
    }
    return val;
  }

  private void lambdaTraversal(int arr[]) {

    int x = Arrays.stream(arr).max().orElse(0);
    System.out.print(x);
  }

  /// Trapping Rain Water////

  private void trapRainWater(int arr[]) {

    int start = 0;
    int mainStart = 0;
    int mainEnd = 0;
    int end = 0;
    int counter = 0;

    for (int i = 0; i < arr.length / 2; i++) {
      if (start < arr[i]) {
        start = arr[i];
        mainStart = i;
      }
    }

    for (int i = arr.length - 1; i > arr.length / 2; i--) {
      if (end < arr[i]) {
        end = arr[i];
        mainEnd = i;
      }
    }

    int valueAdder = start > end ? end : start;

    for (int i = mainStart; i < mainEnd; i++) {
      if (arr[i] == 0) {
        counter += valueAdder;
      } else {
        counter += valueAdder - arr[i];
      }
    }
    System.out.println("Total water can be trapped is: " + counter);
  }

  private void findWater(int arr[], int n) {
    // initialize output
    int result = 0;

    // maximum element on left and right
    int left_max = 0, right_max = 0;

    // indices to traverse the array
    int lo = 0, hi = n - 1;

    while (lo <= hi) {
      if (arr[lo] < arr[hi]) {
        if (arr[lo] > left_max)

          // update max in left
          left_max = arr[lo];
        else

          // water on curr element =
          // max - curr
          result += left_max - arr[lo];
        lo++;
      } else {
        if (arr[hi] > right_max)

          // update right maximum
          right_max = arr[hi];
        else result += right_max - arr[hi];
        hi--;
      }
    }

    System.out.println("Water " + result);
  }

  private void trapRainWater(int[] arr, int len) {
    int lo = 0;
    int high = len - 1;
    int leftMax = 0;
    int rightMax = 0;
    int result = 0;

    while (lo < high) {

      if (arr[lo] < arr[high]) {

        if (arr[lo] > leftMax) {
          leftMax = arr[lo];
        } else {
          result += leftMax - arr[lo];
        }
        lo++;
      } else {
        if (arr[high] > rightMax) {
          rightMax = arr[high];
        } else {
          result += rightMax - arr[high];
        }
        high--;
      }
    }
    System.out.print(result);
  }

  private void palindromeChecker(char[] arr) {

    HashMap<Character, Integer> hm = new HashMap<>();
    int len = arr.length;
    int flag = 0;

    for (int i = 0; i < arr.length; i++) {
      if (hm.containsKey(arr[i])) {
        int temp = hm.get(arr[i]);
        temp++;
        hm.put(arr[i], temp);
      } else {
        hm.put(arr[i], 1);
      }
    }
    for (Integer x : hm.values()) {
      if (x % 2 != 0) {
        flag++;
      }
    }

    if (len % 2 == 0 && flag == 0) {
      System.out.print("Plaindrome");
      return;
    } else if (len % 2 != 0 && flag == 1) {
      System.out.print("Plaindrome");
      return;
    } else {
      System.out.print("Not a plaindrome");
      return;
    }
  }

  private void plaindromeCheckerUpdatd(String str) {

    HashSet<Character> hs = new HashSet<>();

    for (char x : str.toCharArray()) {

      if (hs.contains(x)) {
        hs.remove(x);
      } else {
        hs.add(x);
      }
    }
    if (hs.size() == 1 || hs.size() == 0) {
      System.out.print("Palindrome");
      return;
    } else {
      System.out.print("Not a plaindrome");
      return;
    }
  }

  private void buySellStockUpdated(int arr[]) {
    ArrayList<Integer> buy = new ArrayList<>();
    ArrayList<Integer> sell = new ArrayList<>();
    int buyTemp = Integer.MAX_VALUE;
    int sellTemp = Integer.MIN_VALUE;

    for (int x : arr) {

      if (x < buyTemp) {
        buyTemp = x;
      } else if (x > sellTemp) {
        sellTemp = x;
      }
    }
  }

  private float calculatePower(int x, int y) {

    if (y == 0) {
      return 1;
    } else {
      float temp = calculatePower(x, y / 2);
      if (y % 2 == 0) {
        return temp * temp;
      } else {
        if (y > 0) {
          return x * temp * temp;
        } else {
          return temp * temp / x;
        }
      }
    }
  }

  private void balancer(int arr[], int length) {

    int arrLeft[] = new int[length];
    int arrRight[] = new int[length];

    arrLeft[0] = arr[0];
    arrRight[length - 1] = arr[length - 1];

    for (int i = 1; i < arr.length; i++) {

      if (arrLeft[i - 1] < arr[i]) {
        arrLeft[i] = arr[i];
      }
    }
    for (int i = length - 2; i >= 0; i--) {

      if (arrRight[i + 1] > arr[i]) {
        arrRight[i] = arr[i];
      }
    }

    for (int j = 1; j < length; j++) {
      // if ((arr[j]<arrRight[j+1] && arr[j]> arr[j-1])|| (j==0 && arr[j]<arrRight[j+1]) || j==n-1)
    }
  }

  private void zigZag(int arr[]) {

    Arrays.sort(arr);

    for (int i = 1; i < arr.length - 1; i++) {
      int temp = arr[i + 1];
      arr[i + 1] = arr[i];
      arr[i] = temp;
      i++;
    }
  }

  private void zigZagUpdated(int arr[]) {

    boolean flag = true;

    for (int i = 0; i < arr.length - 1; i++) {

      if (flag) { // < expected
        if (arr[i] > arr[i + 1]) {
          swap(i, i + 1, arr);
        }
      } else { // > expected
        if (arr[i] < arr[i + 1]) {
          swap(i, i + 1, arr);
        }
      }
      flag = !flag;
    }
  }

  private void kthLargestElement(int arr[]) {}

  private void swap(int a, int b, int[] arr) {
    int temp = arr[b];
    arr[b] = arr[a];
    arr[a] = temp;
  }

  private void determineIfUniqueCharacters(String str) {}

  private void findKLargestElement(int arr[], int k) {

    int size = k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < arr.length; i++) {
      if (pq.size() < size) {
        pq.add(arr[i]);
      } else {
        if (pq.peek() < arr[i]) pq.poll();
        pq.add(arr[i]);
      }
    }
    System.out.println(pq.peek());
  }

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
    for (int i : nums) {
      q.offer(i);

      if (q.size() > k) {
        q.poll();
      }
    }

    return q.peek();
  }

  private void relativeSorting(int arr[], int arr1[]) {

    HashMap<Integer, Integer> hm = new HashMap<>();
    int[] output = new int[arr.length];
    int outputCounter = 0;

    for (int x : arr) {
      if (hm.containsKey(x)) {
        int val = hm.get(x);
        val++;
        hm.put(x, val);
      } else {
        hm.put(x, 1);
      }
    }

    for (int j : arr1) {
      int tempOut = hm.get(j);
      int start = outputCounter;
      int end = outputCounter + tempOut;
      while (start < end) {
        output[start] = j;
        start++;
        hm.put(j, null);
      }
      outputCounter += tempOut;
    }

    for (int j : output) {
      System.out.println(j);
    }
  }

  private void longestSubstring(String str) {
    HashSet<Character> hset = new HashSet<>();

    int n = str.length();
    int i = 0;
    int j = 0;
    int size = 0;
    while (i < n && j < n) {
      char temp = str.charAt(j);
      if (!hset.contains(temp)) {
        hset.add(temp);
        size = Math.max(size, j - i);
      } else {
        hset.remove(temp);
        i++;
      }
    }
  }

  private void groupAnagrams(String arr[]) {

    Map<String, List> store = new HashMap<String, List>();
    for (String str : arr) {
      char temp[] = str.toCharArray();
      Arrays.sort(temp);
      String key = String.valueOf(temp);
      if (store.containsKey(key)) {
        store.put(key, new ArrayList());
        store.get(key).add(str);
      }
    }
  }

  private void findPrimeRange(int n) {

    boolean isPrime[] = new boolean[n + 1];
    for (int i = 0; i < n; i++) {
      isPrime[i] = true;
    }

    for (int i = 2; i * i <= n; i++) {

      if (isPrime[i] == true) {
        for (int j = i * i; j <= n; j += i) {
          isPrime[j] = false;
        }
      }
    }
    for (int i = 0; i < isPrime.length; i++) {
      if (isPrime[i] == true) {
        System.out.println(i);
      }
    }
  }

  private void wordCounter(String str) {

    HashMap<String, Integer> hmap = new HashMap<>();

    String[] store = str.split(" ");
    for (int i = 0; i < store.length; i++) {
      store[i] = store[i].toLowerCase();
    }
    for (String x : store) {
      int temp = hmap.getOrDefault(x, 0);
      hmap.put(x, ++temp);
    }
    Iterator<Map.Entry<String, Integer>> iter = hmap.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry<String, Integer> entry = iter.next();
      System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    }
  }

  private void scoreCounter(int arr[], int max) {

    int[] keeper = new int[max + 1];

    for (int x : arr) {
      keeper[x] += 1;
    }

    for (int i = max; i > 0; i--) {

      while (keeper[i] > 0) {
        System.out.println(i);
        keeper[i]--;
      }
    }
  }

  private void stocks(int arr[]) {
    int buy = arr[0];
    int sell = 0;
    int profit = 0;
    for (int i = 1; i < arr.length; i++) {
      if (buy > arr[i]) {
        buy = arr[i];
      } else {
        if (sell < arr[i]) sell = arr[i];
      }
    }
    System.out.println(sell - buy);
  }

  private int productOfMax3(int arr[]) {

    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;

    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {

      if (max1 < arr[i]) {
        max3 = max2;
        max2 = max1;
        max1 = arr[i];
      } else if (max2 < arr[i]) {
        max3 = max2;
        max2 = arr[i];
      } else if (max3 < arr[i]) {
        max3 = arr[i];
      }
      if (min1 > arr[i]) {
        min2 = min1;
        min1 = arr[i];
      } else if (min2 > arr[i]) {
        min2 = arr[i];
      }
    }

    return Math.max((max3 * max2 * max1), (min1 * min2 * max1));
  }

  private void findProductExceptIndex(int[] arr) {

    int[] left = new int[arr.length];
    int[] right = new int[arr.length];
    int prod[] = new int[arr.length];

    left[0] = 1;
    right[arr.length - 1] = 1;

    Arrays.fill(left, 1);
    Arrays.fill(right, 1);

    for (int i = 1; i < arr.length; i++) {

      left[i] = left[i - 1] + arr[i - 1];
    }
    for (int j = arr.length - 2; j >= 0; j--) {
      right[j] = right[j + 1] * arr[j + 1];
    }

    for (int k = 0; k < arr.length; k++) {
      prod[k] = left[k] * right[k];
    }
  }

  private void findDuplicate(int[] arr) {
    for (int i = 0; i < arr.length; i++) {

      System.out.println(arr[Math.abs(arr[i])]);
    }
  }

  private void LongestPalindrome(String str) {

    char[] input = str.toCharArray();

    int fin = input.length - 1;
    int start = 0;
    int tempFin = input.length - 1;
    int tempStart = 0;

    while (tempStart < tempFin) {
      if (input[tempStart] == input[tempFin]) {
        tempStart++;
        tempFin--;
      }
      if (input[tempStart] != input[tempFin]) {
        tempStart++;
        tempFin--;
        start = tempStart;
        fin = tempFin;
      }
    }

    for (int i = start; i <= fin; i++) {
      System.out.println(input[i]);
    }
  }

  public static void main(String[] args) {

    int checker = 0;
    int val1 = 'b' - 'a';
    int val2 = 'c' - 'a';
    // checker |= (1 << val1);
    checker |= (1 << val2);
    // System.out.print(1 << val2);

    if ((checker & (1 << val2)) > 0) {
      // System.out.print("True");
    }

    // System.out.print(checker);

    solution ts = new solution();

    ts.LongestPalindrome("babad");

    int[] findDup = {1, 2, 3, 4, 5};
    // ts.findDuplicate(findDup);

    int stok[] = {10, 7, 5, 8, 11, 9};

    // ts.stocks(stok);

    int score[] = {10, 20, 50, 60, 60};
    // ts.scoreCounter(score, 100);

    // ts.wordCounter("Hello hello world is beautiful is it?");

    // ts.findPrimeRange(10);

    int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
    int A2[] = {2, 1, 8, 3};
    // ts.relativeSorting(A1, A2);

    int test[] = {2, 7, 11, 15, 32};
    // System.out.println(ts.findKthLargest(test, 3));

    // System.out.print(ts.calculatePower(2, -4));

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

    char[] arr1 = {'H', 'E', 'L', 'L', 'O'};
    // ts.reverse(arr);

    int target[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    // ts.subArraySum(target, 15);

    int val[] = {2, 2, 2, 1, 1, 1, 0, 0, 0, 1};
    // ts.sortArray(val);

    int eqi[] = {10, 1, 3, 5, 2};
    // ts.equilibrium(eqi);

    int leader[] = {16, 17, 4, 3, 5, 2};
    // ts.learderinArray(eqi);

    int trainArri[] = {200, 210, 300, 320, 350, 500};
    int trainDepart[] = {230, 340, 320, 430, 400, 520};
    // ts.minPlatformNeeded(trainArri, trainDepart, 6);

    ArrayList<Integer> arrL = new ArrayList<Integer>();
    arrL.add(1);
    arrL.add(2);
    arrL.add(3);
    arrL.add(4);

    // Using lambda expression to print all elements
    // of arrL
    // arrL.forEach(n -> System.out.println(n));

    // ts.lambdaTraversal(trainArri);
    int[] findMax = {1, 2, 3, 1, 4, 5, 2, 3, 6};
    // ts.maximumSubArrayinEach(findMax, 3);

    int[] trapWater = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    // ts.trapRainWater(trapWater);
    // ts.findWater(trapWater, 12);
    char[] str = {'c', 'c', 'a', 'a', 'a'};
    // ts.palindromeChecker(str);
  }
}
