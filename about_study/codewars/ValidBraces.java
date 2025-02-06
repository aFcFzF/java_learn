import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.IntStream;

public class ValidBraces {
  public static void main(String[] args) {
    ValidBraces ins = new ValidBraces();
    System.out.println(ins.checkValidBrace("[(({}))()]"));
    System.out.println(ins.checkValidBrace("[(])"));
    System.out.println(ins.checkValidBrace(")(}{]["));
  }

  private boolean checkValidBrace(String braces) {
    Deque<Character> stack = new ArrayDeque<>();

    for (char ch : braces.toCharArray()) {
      // 右括号
      if (!stack.isEmpty() && this.isClose(stack.peek(), ch)) {
        stack.pop();
      } else {
        stack.push(ch);
      }
    }

    return stack.isEmpty();
  }

  private boolean isClose(char left, char right) {
    return (left == '{' && right == '}') || (left == '(' && right == ')') || (left == '[' && right == ']');
  }
}
