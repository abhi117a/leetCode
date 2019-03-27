public class StringIterator {

  String str;
  int counter = 0;

  StringIterator(String str) {
    this.str = str;
    counter = str.length();
  }

  private char next() {

    char[] test = str.toCharArray();
    for (int i = counter; i < counter; i++) {
      return test[i];
    }
    return ' ';
  }

  private boolean hasNext() {
    int temp = Character.getNumericValue(str.charAt(counter));
    if (temp * 1 == temp) {
      counter++;
      return true;
    }
    counter++;
    return false;
  }
}
