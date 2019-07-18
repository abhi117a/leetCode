import java.util.ArrayList;
import java.util.List;

public class Recursive_BackTracking {

  private List<String> letterCombination(String digits) {

    List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return result;
    }

    String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    letterCombinationRecursive(result, digits, "", 0, mapping);
    return result;
  }

  private void letterCombinationRecursive(
      List<String> result, String digits, String current, int index, String[] mapping) {
    if (index == digits.length()) {
      result.add(current);
      return;
    }
    String letters = mapping[digits.charAt(index) - '0'];
    for (int i = 0; i < letters.length(); i++) {
      letterCombinationRecursive(result, digits, current + letters.charAt(i), index + 1, mapping);
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image[sr][sc] == newColor) {
      return image;
    }
    fill(image, sr, sc, image[sr][sc], newColor);
    return image;
  }

  public void fill(int[][] image, int i, int j, int color, int newColor) {

    if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != color) {
      return;
    }
    image[i][j] = newColor;
    fill(image, i + 1, j, color, newColor);
    fill(image, i - 1, j, color, newColor);
    fill(image, i, j + 1, color, newColor);
    fill(image, i, j - 1, color, newColor);
  }

  private void maxNoIsland(int[][] grid) {
    int maxIslands = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          maxIslands = Math.max(maxIslands, dfsIsland(grid, i, j));
        }
      }
    }
    System.out.println(maxIslands);
  }

  private int dfsIsland(int[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
      return 0;
    }
    grid[i][j] = 0;
    int count = 1;
    count += dfsIsland(grid, i + 1, j);
    count += dfsIsland(grid, i - 1, j);
    count += dfsIsland(grid, i, j + 1);
    count += dfsIsland(grid, i, j - 1);
    return count;
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int res = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          res += dfsHelper(grid, i, j);
        }
      }
    }
    return res;
  }

  public int dfsHelper(char[][] grid, int i, int j) {

    if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
      return 0;
    }
    grid[i][j] = '0';
    dfsHelper(grid, i + 1, j);
    dfsHelper(grid, i - 1, j);
    dfsHelper(grid, i, j + 1);
    dfsHelper(grid, i, j - 1);
    return 1;
  }

  // Leetcode 419. Battleships in a Board

  private int countBattleships(char[][] board) {
    int numOfBattelShip = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'X') {
          numOfBattelShip++;
          battleShipHelper(board, i, j);
        }
      }
    }
    return numOfBattelShip;
  }

  public void battleShipHelper(char[][] board, int i, int j) {

    if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'X') {
      return;
    }
    board[i][j] = '.';
    battleShipHelper(board, i + 1, j);
    battleShipHelper(board, i - 1, j);
    battleShipHelper(board, i, j + 1);
    battleShipHelper(board, i, j - 1);
  }

  private List<List<Integer>> powerSet(int nums[]) {
    List<List<Integer>> subsets = new ArrayList<>();
    generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
    return subsets;
  }

  private void generateSubsets(
      int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
    subsets.add(new ArrayList<>(current));
    for (int i = index; i < nums.length; i++) {
      current.add(nums[i]);
      generateSubsets(i + 1, nums, current, subsets);
      current.remove(current.size() - 1);
    }
  }

  private int divideNumberWithoutMod(int num, int div) {

    if (num < div) {
      return num;
    }

    return divideNumberWithoutMod(num - div, div);
  }

  private int fibonacciRecursion(int n) {
    return fibohelper(n);
  }

  private int fibohelper(int n) {

    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return fibohelper(n - 1) + fibonacciRecursion(n - 2);
  }

  private int recursiveGCD(int m, int n) {

    int counter = m > n ? n : m;
    return GCDhelper(m, n, counter);
  }

  private int GCDhelper(int m, int n, int counter) {

    if (m % counter == 0 && n % counter == 0) {
      return counter;
    }
    return GCDhelper(m, n, --counter);
  }

  private boolean isPrime(int n) {
    int i = n / 2;

    return isPrimeHelper(n, i);
  }

  private boolean isPrimeHelper(int n, int i) {
    if (i == 1) {
      return true;
    }
    if (n % i == 0) {
      return false;
    }

    return isPrimeHelper(n, --i);
  }

  private int convertDecimal(int n) {
    return isConvertDecimal(n, 2);
  }

  private int isConvertDecimal(int n, int i) {

    if (n < i) {
      return n;
    }
    int val = isConvertDecimal(n / 2, i);
    return val;
  }

  private String reverseString(String myStr) {
    if (myStr.isEmpty()) {
      return myStr;
    } else {
      return reverseString(myStr.substring(1)) + myStr.charAt(0);
    }
  }

  private String removeDuplicate(String myStr) {

    if (myStr.length() == 1) {
      return myStr;
    }
    if (myStr.substring(0, 1).equals(myStr.substring(1, 2))) {
      return removeDuplicate(myStr.substring(1));
    } else {
      return (myStr.substring(0, 1)) + removeDuplicate(myStr.substring(1));
    }
  }

  public static void main(String args[]) {
    Recursive_BackTracking rb = new Recursive_BackTracking();
    // rb.letterCombination("23");

    //  System.out.println(rb.divideNumberWithoutMod(10, 3));
    // System.out.println(rb.recursiveGCD(1200, 2048));

    // System.out.println(rb.isPrime(7));

    // System.out.println(rb.convertDecimal(19));

    System.out.println(rb.reverseString("Hello"));
  }
}
