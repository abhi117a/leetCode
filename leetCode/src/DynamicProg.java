import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DynamicProg {

  private void maximumSubArray(int[] a) {

    int maxValue = 0;
    int[] bank = new int[a.length];
    bank[0] = 0;
    for (int i = 1; i < a.length; i++) {
      // Max of [Either you take the current value or not]
      bank[i] = Math.max(bank[i - 1], bank[i - 1] + a[i - 1]);
    }
  }

  // Count number of ways to reach a given score in a game

  private void CountNumberOfWays(int n) {
    int scorePattern[] = {3, 5, 10};
    int[] table = new int[n + 1];
    Arrays.fill(table, 0);
    // Initiate the value of 0th index =1;
    table[0] = 1;
    for (int i = 3; i <= n; i++) {
      table[i] += table[i - 3];
    }
    for (int i = 5; i <= n; i++) {
      table[i] += table[i - 5];
    }
    for (int i = 10; i <= n; i++) {
      table[i] += table[i - 10];
    }

    System.out.println(table[n]);
  }

  // Given 2 strings how many edits will it take to make them equal (replace, remove, add)
  private void minEditDistance(String p, String q, int m, int n) {

    int[][] bank = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0) {
          bank[i][j] = j;
        } else if (j == 0) {
          bank[i][j] = i;
        } else if (p.charAt(i - 1) == q.charAt(j - 1)) {
          // If equal then pick diagonal
          bank[i][j] = bank[i - 1][j - 1];
        } else {
          // Min of 3 i.e. left,upper,diagonal
          bank[i][j] = 1 + minFunc(bank[i - 1][j - 1], bank[i - 1][j], bank[i][j - 1]);
        }
      }
    }
    /*
    *     [i][j-1],  // Insert
         [i-1][j],  // Remove
       [i-1][j-1]); // Replace
    * */
    System.out.println(bank[m][n]);
  }

  private int minFunc(int x, int y, int z) {
    if (x <= y && x <= z) {
      return x;
    }
    if (y <= x && y <= z) {
      return y;
    } else return z;
  }

  private void findAllPossibleTrees(int n) {

    int[] T = new int[n + 1];
    T[0] = 1;
    T[1] = 1;
    int sum = 0;
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        sum += T[j] * T[i - j - 1];
      }
      T[i] = sum;
    }
  }

  private void BinomialCoefficient(int n, int k) {

    int[][] bank = new int[n + 1][k + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= k; j++) {
        if (j == 0 || j == i) {
          bank[i][j] = 1;
        } else {
          bank[i][j] = bank[i - 1][j - 1] + bank[i - 1][j];
        }
      }
    }
  }

  private void knapSackProblem(int W, int[] w, int[] v) {

    int m = v.length + 1;
    int n = W + 1;

    int[][] bank = new int[m][n];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0) {
          // If values ==0 then weights cannot help
          bank[i][j] = 0;
        } else if (j == 0) {
          // if weights ==0 then no values can help
          bank[i][j] = 0;
        } else if (j - w[i - 1] < 0) {
          bank[i][j] = bank[i - 1][j];
        } else {
          bank[i][j] = Math.max(bank[i - 1][j], bank[i - 1][j - w[i - 1]] + v[i - 1]);
        }
      }
    }
  }

  public int coinChange(int[] coins, int amount) {

    int bank[] = new int[amount + 1];
    Arrays.fill(bank, amount + 1);
    bank[0] = 0;
    for (int coin : coins) {
      for (int i = 0; i < bank.length; i++) {
        if (coin <= i) {
          bank[i] = Math.min(bank[i], 1 + bank[i - coin]);
        }
      }
    }
    return bank[amount] > amount ? -1 : bank[amount];
  }

  // Given an input string and a dictionary of words, find out if the input string can be segmented
  // into a space-separated sequence of dictionary words. See following examples for more details.

  private void wordBreak(String s, List<String> wordDict) {

    Set<String> wordDictSet = new HashSet(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {

        if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
  }

  private void StairCase(int n) {
    int[] bank = new int[n + 1];
    bank[0] = 1;
    bank[1] = 1;
    bank[2] = 2;
    // bank[3] = 4;

    for (int i = 3; i <= n; i++) {
      bank[i] = bank[i - 1] + bank[i - 2] + bank[i - 3];
    }
    System.out.println(bank[n]);
  }

  private int buySellStockDynamic(int prices[]) { // buy sell stock

    if (prices == null || prices.length == 0) return 0;
    int currentProfit = 0, maximumProfit = 0, minPrice = Integer.MAX_VALUE;

    for (int i = 0; i < prices.length; i++) {
      minPrice = Math.min(minPrice, prices[i]);
      currentProfit = prices[i] - minPrice;
      maximumProfit = Math.max(maximumProfit, currentProfit);
    }

    return maximumProfit;
  }

  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;

    int m = grid.length;
    int n = grid[0].length;

    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (i == 0) {
          dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        if (j == 0) {
          dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    return dp[m - 1][n - 1];
  }

  // Longest Palindromic Substring

  private String longestPalindrome(String s) {

    if (s.isEmpty()) {
      return s;
    } else if (s.length() == 1) {
      return s;
    }

    String longest = s.substring(0, 1);

    for (int i = 0; i < s.length(); i++) {

      // Checking for center i (odd length string)
      String tmp = helper(s, i, i);
      if (tmp.length() > longest.length()) {
        longest = tmp;
      }

      // Checking for center i and i+1 (even length string)

      tmp = helper(s, i, i + 1);
      if (tmp.length() > longest.length()) {
        longest = tmp;
      }
    }
    return longest;
  }

  private String helper(String s, int start, int end) {

    while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
      start--;
      end++;
    }
    return s.substring(start + 1, end);
  }

  public static void main(String[] args) {

    DynamicProg dp = new DynamicProg();
    // dp.CountNumberOfWays(20);
    dp.StairCase(4);
  }
}
