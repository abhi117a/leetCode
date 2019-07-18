import java.util.*;
import java.util.LinkedList;

public class Graphs {

  // Word Ladder - Medium

  private int WordLadder(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) {
      return 0;
    }
    int result = 0;
    Queue<String> qu = new LinkedList<>();
    if (beginWord == endWord) {
      return 0;
    }

    qu.offer(beginWord);
    while (!qu.isEmpty()) {
      int size = qu.size();
      for (int k = size; k > 0; k--) {
        String inp = qu.poll();
        if (inp.equals(endWord)) {
          return result + 1;
        }
        for (int i = 0; i < inp.length(); i++) {
          char[] inputChar = inp.toCharArray();
          for (char x = 'a'; x <= 'z'; ++x) {
            inputChar[i] = x;
            String inputConverted = new String(inputChar);
            if (wordSet.contains(inputConverted) && (!inputConverted.equals(beginWord))) {
              qu.offer(inputConverted);
              wordSet.remove(inputConverted);
            }
          }
        }
      }
      result++;
    }

    return 0;
  }

  private int wordLadder(String beginWord, String endWord, List<String> wordList) {
    HashSet<String> hs = new HashSet<>(wordList);
    int result = 0;
    if (beginWord == endWord) {
      return 0;
    }
    Queue<String> qu = new LinkedList<>();
    qu.offer(beginWord);
    while (!qu.isEmpty()) {
      for (int k = qu.size(); k > 0; k--) {
        String inp = qu.poll();
        for (int i = 0; i < inp.length(); i++) {
          char[] converted = inp.toCharArray();
          for (char x = 'a'; x <= 'z'; x++) {
            converted[i] = x;
            String reString = new String(converted);
            if (hs.contains(reString) && !reString.equals(beginWord)) {
              qu.offer(reString);
              hs.remove(reString);
            }
          }
        }
      }
      result++;
    }
    return result;
  }

  public static void main(String args[]) {

    Graphs g = new Graphs();
  }
}
