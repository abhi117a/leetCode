import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Stacks_Queues {

  private void checkingMaxWithStack(int[] val) {

    Stack<Integer> st = new Stack<>();
    HashMap<String, Integer> hm = new HashMap<>();

    Stack<Integer> stMax = new Stack<>();
    int max = Integer.MIN_VALUE;

    for (int x : val) {
      if (max < x) {
        max = x;
      }
      st.push(x);
      stMax.push(max);
    }
  }

  private void reversePolishNotation(String[] value) {

    Set<String> operators = new HashSet<>();
    operators.add("+");
    operators.add("-");
    operators.add("*");
    operators.add("/");
    String operator = "";
    int sum = 0;
    Stack<String> st = new Stack<>();
    for (String x : value) {

      if (operators.contains(x)) {
        operator = x;
        int right = Integer.parseInt(st.pop());
        int left = Integer.parseInt(st.pop());

        switch (operator) {
          case "+":
            sum = left + right;
            break;
          case "-":
            sum = left - right;
            break;
          case "*":
            sum = left * right;
            break;
          case "/":
            sum = left / right;
            break;
        }
        st.push(Integer.toString(sum));
      } else st.push(x);
    }
    System.out.println(st.pop());
  }

  public static void main(String args[]) {
    Stacks_Queues stt = new Stacks_Queues();
    String[] arr = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    stt.reversePolishNotation(arr);
  }
}
