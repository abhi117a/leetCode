import java.util.*;
import java.util.Arrays;

public class HashTable_Map {

  private void findNearestSameValues(List<String> arr) {

    HashMap<String, Integer> hm = new HashMap<>();
    int minDist = Integer.MAX_VALUE;

    for (int i = 0; i < arr.size(); i++) {
      if (hm.containsKey(arr.get(i))) {
        int val = hm.get(arr.get(i));
        minDist = i - val < minDist ? i - val : minDist;
      }
      hm.put(arr.get(i), i);
    }
    System.out.println(minDist);
  }

  // Length of the largest subarray with contiguous elements

  private void contigousElements(int arr[]) {

    int mx = arr[0];
    int mn = arr[0];
    int globMax = 1;

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        mx = Math.max(mx, arr[j]);
        mn = Math.min(mn, arr[j]);

        if (mx - mn == j - i) {
          globMax = globMax > j - i + 1 ? globMax : j - i + 1;
        }
      }
    }
  }

  private int FirstUniqueCharacterInAString(String str) {
    int index = -1;
    int min = Integer.MAX_VALUE;
    Map<Character, Integer> ht = new HashMap<>();
    for (int i = str.length() - 1; i >= 0; i--) {

      int tmp = ht.getOrDefault(str.charAt(i), Integer.MIN_VALUE);
      if (tmp == Integer.MIN_VALUE) {
        ht.put(str.charAt(i), i);
      } else {
        ht.put(str.charAt(i), -1);
      }
    }
    for (char x : ht.keySet()) {
      if (ht.get(x) != -1) {
        min = min < ht.get(x) ? min : ht.get(x);
      }
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }

  // Given a non-empty array of integers, every element appears twice except for one. Find that
  // single one.

  private int SingleNumber(int arr[]) {

    Set<Integer> ht = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      if (ht.contains(arr[i])) {
        ht.remove(arr[i]);
      } else {
        ht.add(arr[i]);
      }
    }
    for (int x : arr) {
      if (ht.contains(x)) {
        return x;
      }
    }
    return -1;
  }

  private int missingNumber(int[] arr) {
    Set<Integer> st = new HashSet<>();
    for (int x : arr) {
      st.add(x);
    }
    for (int i = 0; i <= arr.length; i++) {
      if (!st.contains(i)) {
        return i;
      }
    }
    return -1;
  }
  // You're given strings J representing the types of stones that are jewels, and S representing the
  // stones you have.  Each character in S is a type of stone you have.  You want to know how many
  // of the stones you have are also jewels.
  //
  // The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters
  // are case sensitive, so "a" is considered a different type of stone from "A".

  private void jewelsStones(String J, String a) {

    int counter = 0;
    HashSet<Character> hs = new HashSet<>();
    for (int i = 0; i < J.length(); i++) {
      hs.add(J.charAt(i));
    }

    for (int i = 0; i < a.length(); i++) {
      counter += (hs.contains(a.charAt(i)) == true) ? 1 : 0;
    }
    System.out.println(counter);
  }

  // Given a paragraph and a list of banned words, return the most frequent word that is not in the
  // list of banned words.  It is guaranteed there is at least one word that isn't banned, and that
  // the answer is unique.
  //
  // Words in the list of banned words are given in lowercase, and free of punctuation.  Words in
  // the paragraph are not case sensitive.  The answer is in lowercase.
  // ----------Not done yet-----------
  private void mostCommonWords(String para, String[] banned) {
    String[] par = para.split(" ");
    HashMap<String, Integer> hm = new HashMap<>();
    Set<String> ban = new HashSet<>();
    for (String w : banned) {
      ban.add(w);
    }
    for (int i = 0; i < par.length; i++) {
      if (!ban.contains(par[i])) {
        int tmp = hm.getOrDefault(par[i], 0);
        hm.put(par[i], ++tmp);
      }
    }
  }
  // Given an array of strings, group anagrams together.
  //
  // Example:
  //
  // Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
  // Output:
  // [
  //  ["ate","eat","tea"],
  //  ["nat","tan"],
  //  ["bat"]
  // ]
  private void GroupedAnaGrams(String[] strs) {

    HashMap<String, List<String>> group = new HashMap<>();

    for (String curr : strs) {
      char[] characters = curr.toCharArray();
      Arrays.sort(characters);
      String sorted = new String(characters);

      if (!group.containsKey(sorted)) {
        group.put(sorted, new ArrayList<>());
      }

      group.get(sorted).add(curr);
    }
  }
  // Given a string which consists of lowercase or uppercase letters, find the length of the longest
  // palindromes that can be built with those letters.
  //
  // This is case sensitive, for example "Aa" is not considered a palindrome here.
  public int longestPalindrome(String s) {
    int totalLen = 0;
    Map<Character, Integer> hm = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      int tmp = hm.getOrDefault(s.charAt(i), 0);
      hm.put(s.charAt(i), ++tmp);
    }

    for (int x : hm.values()) {

      totalLen += (x / 2 * 2);
      if (totalLen % 2 == 0 && x % 2 != 0) {
        totalLen++;
      }
    }

    return totalLen;
  }

  // Individuals with zero parents

  /*Facebook Phone Screen*/

  /*
       *
       *
       *
       *Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

    For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

    1   2   4
     \ /   / \
      3   5   8
       \ / \   \
        6   7   10

    Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.

       *findNodesWithZeroAndOneParents(parentChildPairs) => [
    [1, 2, 4],    // Individuals with zero parents
    [5, 7, 8, 10] // Individuals with exactly one parent
  ]

       * */

  private Set<Integer> findParents(int[][] input) {

    Set<Integer> parents = new HashSet<>();
    for (int i = 0; i < input.length; i++) {
      int[] curr = input[i];
      parents.add(curr[0]);
    }

    for (int i = 0; i < input.length; i++) {
      int[] curr = input[i];
      if (parents.contains(curr[1])) {
        parents.remove(curr[1]);
      }
    }

    Set<Integer> children = new HashSet<>();
    for (int i = 0; i < input.length; i++) {
      int[] curr = input[i];

      if (children.contains(curr[1])) {
        children.remove(curr[1]);
      } else {
        children.add(curr[1]);
      }
    }

    return children;
  }
  // 169. Majority Element

  private int majorityElement(int[] nums) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int max = 0;
    int ans = 0;
    for (int x : nums) {
      int count = hm.getOrDefault(x, 0);
      hm.put(x, ++count);
    }

    for (int keys : hm.keySet()) {
      if (hm.get(keys) > max) {
        ans = keys;
        max = hm.get(keys);
      }
    }
    return ans;
  }

  public static void main(String args[]) {

    HashMap<Integer, Integer> hom = new HashMap<>();

    hom.put(1, 0);
    hom.put(2, 0);

    if (hom.values().equals(0)) {
      System.out.println("HAJS");
    }

    List<String> a = new ArrayList<>();
    a.add("foo");
    a.add("bar");
    a.add("wi");
    a.add("foo");
    a.add("wi");
    a.add("ad");
    HashTable_Map hot = new HashTable_Map();
    hot.findNearestSameValues(a);
    hot.FirstUniqueCharacterInAString("loveleetcode");
    int[] arr = {0};
    // System.out.println(hot.SingleNumber(arr));
    // System.out.println(hot.missingNumber(arr));
    int[][] parentChildPairs =
        new int[][] {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 10}};

    System.out.println(hot.findParents(parentChildPairs));
  }
}
