import java.util.HashSet;
import java.util.Set;

public class solution2 {

  private void longestSubstringNonRepeating(String input) {

    Set<Character> st = new HashSet<>();

    int i = 0;
    int j = 0;
    int ans = 0;
    int n = input.length();
    while (i < n && j < n) {

      if (!st.contains(input.charAt(j))) {
        st.add(input.charAt(j++));
        ans = Math.max(ans, j - i);
      } else {
        st.remove(input.charAt(i++));
      }
    }
    System.out.println(ans);
  }

  private void numJewelsInStones(String J, String S) {

    Set<Character> st = new HashSet<>();
    int ans = 0;

    for (int i = 0; i < J.length(); i++) {
      st.add(J.charAt(i));
    }

    for (int k = 0; k < S.length(); k++) {

      if (st.contains(S.charAt(k))) {
        ans++;
      }
    }
  }

  private void givPrimeNumberforSum(int n) {

    boolean isPrime[] = new boolean[n + 1];
    findPrimeforNumber(n, isPrime);

    for (int i = 0; i < n; i++) {
      if (isPrime[i] == false && isPrime[n - i] == false) {
        System.out.println(i + "" + (n - i));
      }
    }
  }

  private boolean findPrimeforNumber(int n, boolean isPrime[]) {

    isPrime[0] = false;
    isPrime[1] = false;

    for (int p = 2; p * p < n; p++) {
      if (isPrime[p] == true) {
        for (int i = p * p; i < n; i += p) {
          isPrime[p] = false;
        }
      }
    }
    return false;
  }

  // handles positive number//
  private void subArraySumEquals(int num[], int k) {

    Set<Integer> st = new HashSet<>();
    int ans = 0;
    int start = 0;

    for (int i = 0; i <= num.length; i++) {

      while (ans > k && i < num.length) {
        ans -= num[start];
        start++;
      }
      if (ans < k) {
        ans += num[i];
        st.add(i);
      } else if (ans == k) {
        System.out.println("Found the value" + start + " " + --i);
        return;
      }
    }
  }

  private void minimumSteps2DGrid(point p1, point p2) {

    int x = Math.abs(p1.x - p2.x);
  }

  public static void main(String args[]) {
    solution2 ts2 = new solution2();

    int num[] = {15, 2, 4, 8, 9, 5, 10, 23};
    ts2.subArraySumEquals(num, 23);
  }
}

class point {
  int x, y;

  point(int a, int b) {
    x = a;
    y = b;
  }
}
