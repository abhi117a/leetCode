package practiceLeetCode;

public class practiceLeetCode {

  //// Compare two version numbers version1 and version2.
  // If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
  //
  // You may assume that the version strings are non-empty and contain only digits and the .
  // character.
  //
  // The . character does not represent a decimal point and is used to separate number sequences.
  //
  // For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth
  // second-level revision of the second first-level revision.
  //
  // You may assume the default revision number for each level of a version number to be 0. For
  // example, version number 3.4 has a revision number of 3 and 4 for its first and second level
  // revision number. Its third and fourth level revision number are both 0.

  public int compareVersion(String version1, String version2) {

    int lastAns = 0;

    if (version1.length() > version2.length()) {
      lastAns = 1;
    } else if (version1.length() < version2.length()) {
      lastAns = -1;
    } else {
      lastAns = 0;
    }

    String[] ver1 = version1.split("\\.");
    String[] ver2 = version2.split("\\.");

    int i = 0;
    while (i < ver1.length || i < ver2.length) {
      if (i < ver1.length && i < ver2.length) {
        if (Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[i])) {
          return 1;
        } else if (Integer.parseInt(ver1[i]) < Integer.parseInt(ver2[i])) {
          return -1;
        } else if (i < ver1.length && Integer.parseInt(ver1[i]) != 0) {
          return 1;
        } else if (i < ver2.length && Integer.parseInt(ver2[i]) != 0) {
          return -1;
        }
      }
      i++;
    }
    return 0;
  }

  public static void main(String args[]) {

    practiceLeetCode pc = new practiceLeetCode();
    System.out.println(pc.compareVersion("01", "1"));
  }
}
