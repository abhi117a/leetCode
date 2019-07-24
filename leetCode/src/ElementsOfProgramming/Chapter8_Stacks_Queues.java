package ElementsOfProgramming;

import java.util.Stack;

/**
 * 8.1 - done 8.2 - done 8.3 - done
 *
 * <p>*
 */

// EPI 8.4

public class Chapter8_Stacks_Queues {

  private String simplify(String path) {

    StringBuilder sb = new StringBuilder();
    String pat[] = path.split("/");
    Stack<String> st = new Stack<>();

    for (String x : pat) {
      if (x.length() == 0 || x.equals(".")) ;
      else if (x.equals("..")) {
        if (!st.isEmpty()) {
          st.pop();
        }
      } else {
        st.push(x);
      }
    }
    if (st.isEmpty()) {
      sb.append("/");
    } else {
      while (!st.isEmpty()) {
        sb.insert(0, st.pop());
        sb.insert(0, "/");
      }
    }
    return sb.toString();
  }

  public static void main(String args[]) {
    Chapter8_Stacks_Queues c8 = new Chapter8_Stacks_Queues();
    System.out.println(c8.simplify("/a/./b/../../c/"));
  }
}
