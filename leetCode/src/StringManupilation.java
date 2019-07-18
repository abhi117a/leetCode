import java.util.*;

public class StringManupilation {

  // Every email consists of a local name and a domain name, separated by the @ sign.
  //
  // For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain
  // name.
  //
  // Besides lowercase letters, these emails may contain '.'s or '+'s.
  //
  // If you add periods ('.') between some characters in the local name part of an email address,
  // mail sent there will be forwarded to the same address without dots in the local name.  For
  // example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
  // (Note that this rule does not apply for domain names.)
  //
  // If you add a plus ('+') in the local name, everything after the first plus sign will be
  // ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be
  // forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
  //
  // It is possible to use both of these rules at the same time.
  //
  // Given a list of emails, we send one email to each address in the list.  How many different
  // addresses actually receive mails?

  private void commonEmailAddress(String[] emails) {
    Set<String> bank = new HashSet<>();

    String ans = "";
    for (String email : emails) {
      StringBuilder sb = new StringBuilder();
      String[] breakAT = email.split("@");
      String[] breakPlus = breakAT[0].split("\\+");
      String dotRemove = breakPlus[0].replaceAll("\\.", "");
      sb.append(dotRemove);
      sb.append("@");
      sb.append(breakAT[1]);
      ans = sb.toString();
      bank.add(ans);
    }
    System.out.println(bank.size());
  }

  private void verifyPalinDrome(String str) {
    int left = 0;
    int right = str.length() - 1;

    while (left < right) {
      if (!Character.isLetterOrDigit(str.charAt(left))) {
        left++;
      }
      if (!Character.isLetterOrDigit(str.charAt(right))) {
        right--;
      }
      if (str.toLowerCase().charAt(left) != str.toLowerCase().charAt(right)) {
        return;
      }
    }
    System.out.println("true");
  }

  private void reverseAString(String str) {

    StringBuilder sb = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      sb.append(str.charAt(i));
    }
    System.out.println(sb.toString());
  }

  public String longestCommonPrefix(String[] strs) {

    StringBuilder result = new StringBuilder();

    if (strs == null || strs.length == 0) {
      return "";
    }
    int index = 0;
    for (char x : strs[0].toCharArray()) {

      for (int i = 1; i < strs.length; i++) {
        if (index >= strs[i].length() || x != strs[i].charAt(index)) {
          return result.toString();
        }
      }
      result.append('x');
      System.out.println(index);
      index++;
    }
    String fin = new String(result);
    return fin;
  }

  private void longestSubstringWithoutRepeatingCharacters(String s) {

    Set<Character> checkSet = new HashSet<>();

    int left = 0;
    int right = 0;
    int maxLength = -1;

    while (right < s.length()) {
      if (!checkSet.contains(s.charAt(right))) {
        checkSet.add(s.charAt(right));
        right++;
        maxLength = Math.max(maxLength, right - left);
      } else {
        checkSet.remove(s.charAt(left));
        left++;
      }
    }

    System.out.println(maxLength);
  }

  private void stringATOI(String s) {

    s = s.trim();

    if (s.equals(null) || s.length() < 1) {
      System.out.println(0);
      return;
    }

    char flag = '+';

    double result = 0;
    int index = 0;
    if (s.charAt(index) == '-') {
      flag = '-';
      index++;
    }
    while (index < s.length() && (s.charAt(index) >= '0' && s.charAt(index) <= '9')) {
      result = result * 10 + (s.charAt(index) - '0');
      index++;
    }
    if (flag == '-') {
      result = -result;
    }
    if (result < Integer.MIN_VALUE) {
      System.out.println(Integer.MIN_VALUE);
      return;
    }
    if (result > Integer.MAX_VALUE) {
      System.out.println(Integer.MAX_VALUE);
      return;
    }
    System.out.println(result);
  }

  public String intToRoman(int num) {

    int[] regular = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romas = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < regular.length; i++) {
      while (num - regular[i] >= 0) {
        sb.append(romas[i]);
        num = num - regular[i];
      }
    }
    return sb.toString();
  }

  private int RomantoInt(String s) {

    if (s == null || s.length() == 0) {
      return 0;
    }

    Map<Character, Integer> romanValues = new HashMap<>();
    romanValues.put('I', 1);
    romanValues.put('V', 5);
    romanValues.put('X', 10);
    romanValues.put('L', 50);
    romanValues.put('C', 100);
    romanValues.put('D', 500);
    romanValues.put('M', 1000);

    int length = s.length();
    int result = s.charAt(length - 1);

    for (int i = 0; i < length - 2; i += 2) {
      if (romanValues.get(s.charAt(i)) >= romanValues.get(s.charAt(i + 1))) {
        result += romanValues.get(s.charAt(i));

      } else {
        result -= romanValues.get(s.charAt(i));
      }
    }
    return result;
  }

  public int strStr(String haystack, String needle) {
    int index = 0;
    int startOcuurence = 0;
    for (int i = 0; i < haystack.length(); i++) {
      for (int j = 0; j < needle.length(); j++) {
        if (haystack.charAt(i) == needle.charAt(j)) {
          if (index == 0) {
            startOcuurence = i;
          }
        } else {
          startOcuurence = -1;
        }
      }
    }
    return startOcuurence;
  }

  public int compareVersion(String version1, String version2) {

    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int len = v1.length > v2.length ? v1.length : v2.length;
    for (int i = 0; i < len; i++) {
      int v1i = v1.length > i ? Integer.parseInt(v1[i]) : 0;
      int v2i = v2.length > i ? Integer.parseInt(v2[i]) : 0;
      if (v1i > v2i) {
        return 1;
      }
      if (v1i < v2i) {
        return -1;
      }
    }
    return 0;
  }
  // Minimum window substring
  public String minWindow(String searchString, String t) {

    Map<Character, Integer> requiredCharacters = buildMappingOfCharactersToOccurrences(t);

    Map<Character, Integer> windowCharacterMapping = new HashMap<Character, Integer>();

    int left = 0;
    int right = 0;

    int totalCharFrequenciesToMatch = requiredCharacters.size();
    int charFrequenciesInWindowThatMatch = 0;

    int minWindowLengthSeenSoFar = Integer.MAX_VALUE;
    String minWindow = "";

    while (right < searchString.length()) {

      char characterAtRightPointer = searchString.charAt(right);
      addCharacterToHashtableMapping(windowCharacterMapping, characterAtRightPointer);

      boolean rightCharIsARequirement = requiredCharacters.containsKey(characterAtRightPointer);
      if (rightCharIsARequirement) {

        boolean requirementForCharacterMet =
            requiredCharacters.get(characterAtRightPointer).intValue()
                == windowCharacterMapping.get(characterAtRightPointer).intValue();
        if (requirementForCharacterMet) {

          charFrequenciesInWindowThatMatch++;
        }
      }

      while (charFrequenciesInWindowThatMatch == totalCharFrequenciesToMatch && left <= right) {

        char characterAtLeftPointer = searchString.charAt(left);
        int windowSize = right - left + 1;

        if (windowSize < minWindowLengthSeenSoFar) {
          minWindowLengthSeenSoFar = windowSize;
          minWindow = searchString.substring(left, right + 1);
        }

        windowCharacterMapping.put(
            characterAtLeftPointer, windowCharacterMapping.get(characterAtLeftPointer) - 1);

        boolean leftCharIsARequirement = requiredCharacters.containsKey(characterAtLeftPointer);
        if (leftCharIsARequirement) {

          boolean characterFailsRequirement =
              windowCharacterMapping.get(characterAtLeftPointer).intValue()
                  < requiredCharacters.get(characterAtLeftPointer).intValue();

          if (characterFailsRequirement) {

            charFrequenciesInWindowThatMatch--;
          }
        }

        left++;
      }

      right++;
    }

    return minWindow;
  }

  private Map<Character, Integer> buildMappingOfCharactersToOccurrences(String s) {

    Map<Character, Integer> map = new HashMap<Character, Integer>();

    for (int i = 0; i < s.length(); i++) {
      int occurrencesOfCharacter = map.getOrDefault(s.charAt(i), 0);
      map.put(s.charAt(i), occurrencesOfCharacter + 1);
    }

    return map;
  }

  private void addCharacterToHashtableMapping(Map<Character, Integer> map, Character c) {
    int occurrences = map.getOrDefault(c, 0);
    map.put(c, occurrences + 1);
  }

  // A log file consists of a day and userId, find number of unique user on given day
  // 12:08:1988 abhi117 dkjsdkf
  // 12:08:1900 akanks dkjsdkf
  // Amazon Onsite
  private void maxNumOfPeopleonOneDay(List<String> input) {
    HashMap<String, Set<String>> hm = new HashMap<>();

    for (int i = 0; i < input.size(); i++) {
      String arr[] = input.get(i).split(" ");
      if (!hm.containsKey(arr[0])) {
        hm.put(arr[0], new HashSet<>());
      }
      hm.get(arr[0]).add(arr[1]);
    }
  }

  // Given a string, return the first recurring character in it, or null if there is no recurring
  // character.
  // For example, given the string "acbbac", return "b". Given the string "abcdef", return null.

  private Character firstRecurringCharacter(String s) {

    HashMap<Character, Integer> hm = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {

      int tmp = hm.getOrDefault(s.charAt(i), 0);
      hm.put(s.charAt(i), ++tmp);
    }

    for (Character x : s.toCharArray()) {
      if (hm.get(x) == 1) {
        return x;
      }
    }
    return null;
  }
  // Backspace String Compare
  private boolean backspaceCompare(String S, String T) {

    int m = S.length() - 1;
    int n = T.length() - 1;

    Stack<Character> S_ = new Stack<>();
    Stack<Character> T_ = new Stack<>();

    for (int i = S.length() - 1; i >= 0; i--) {
      if (S.charAt(i) != '#') {
        S_.push(S.charAt(i));
      } else {
        if (!S_.isEmpty()) {
          S_.pop();
        }
      }
    }

    for (int i = T.length() - 1; i >= 0; i--) {
      if (T.charAt(i) != '#') {
        T_.push(T.charAt(i));
      } else {
        if (!T_.isEmpty()) {
          T_.pop();
        }
      }
    }

    while (!S_.isEmpty() && !T_.isEmpty()) {
      Character so = S_.pop();
      Character to = T_.pop();
      if (so == to) ;
      else {
        return false;
      }
    }
    return S_.isEmpty() && T_.isEmpty();
  }

  private String nextClosestTime(String time) {

    String[] mins = time.split(":");
    int totMin = Integer.parseInt(mins[0]) * 60;
    totMin += Integer.parseInt(mins[1]);

    HashSet<Integer> digits = new HashSet<>();
    for (char x : time.toCharArray()) {
      digits.add(x - '0');
    }

    while (true) {
      totMin = (totMin + 1) % (24 * 60);
      int[] nextTime = {totMin / 60 / 10, totMin / 60 % 10, totMin % 60 / 10, totMin % 60 % 10};
      boolean isValid = true;
      for (int x : nextTime) {
        if (!digits.contains(x)) {
          isValid = false;
          break;
        }
      }
      if (isValid) {
        return String.format("%02d:%02d", totMin / 60, totMin % 60);
      }
    }
  }

  // LeetCode #293
  private List<String> flipGame(String s) {

    List<String> result = new ArrayList<>();
    int i = 0;
    while (i < s.length()) {
      int nextMove = i == 0 ? s.indexOf("++") : s.indexOf("++", i);
      if (nextMove == -1) {
        return result;
      }
      String nextState = s.substring(0, nextMove) + "--" + s.substring(nextMove + 2);
      result.add(nextState);
      i = nextMove + 1;
    }
    return result;
  }

  // Leetcode 482. License Key Formatting

  private String licenseKeyFormatting(String S, int K) {
    S = S.toUpperCase();
    Stack<Character> st = new Stack<>();
    int counter = K;
    StringBuilder sb = new StringBuilder();
    for (char x : S.toCharArray()) {
      if (x != '-') {
        st.push(x);
      }
    }

    while (!st.isEmpty()) {

      if (counter > 0) {
        sb.append(st.pop());
        counter--;
      } else {
        sb.append('-');
        counter = K;
      }
    }
    return sb.reverse().toString();
  }

  // Correct Solution Leetcode 125. Valid Palindrome
  private boolean validPalindrome(String s) {

    int left = 0;
    int right = s.length() - 1;

    while (left < right) {

      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {

        right--;
      }

      if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
        return false;
      }
    }
    return true;
  }

  // 680. Valid Palindrome II

  private boolean ValidPalindrome2(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {

      if (s.charAt(left) != s.charAt(right)) {

        return ValidPalindrome2helper(s, left + 1, right)
            || ValidPalindrome2helper(s, left, right - 1);
      }

      left++;
      right--;
    }

    return true;
  }

  private boolean ValidPalindrome2helper(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left++) != s.charAt(right--)) {
        return false;
      }
    }
    return true;
  }
  // Leetcode 67. Add Binary
  private String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0) {

      int sum = carry;
      if (i >= 0) {
        sum += a.charAt(i--) - '0';
      }
      if (j >= 0) {
        sum += b.charAt(j--) - '0';
      }

      sb.insert(0, sum % 2);
      carry = sum / 2;
    }
    if (carry > 0) {
      sb.insert(0, 1);
    }

    return sb.toString();
  }

  public static void main(String args[]) {
    StringManupilation sm = new StringManupilation();
    String[] emails = {
      "test.email+alex@leetcode.com",
      "test.e.mail+bob.cathy@leetcode.com",
      "testemail+david@lee.tcode.com"
    };

    // sm.licenseKeyFormatting("5F3Z-2e-9-w", 4);

    // sm.commonEmailAddress(emails);

    // sm.reverseAString("Hello");

    String[] strs = {"flower", "flow", "fight"};
    // sm.longestCommonPrefix(strs);

    // sm.longestSubstringWithoutRepeatingCharacters("pwwkew");
    // sm.stringATOI("   -42");

    // sm.compareVersion("7.5.2.4", "7.05.3");

    System.out.println(sm.addBinary("11", "1"));
  }
}
