import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;
import java.util.Deque;

public class RomanNumbersEncoder {
  public static HashMap<Integer, String> dict;

  public static void main(String[] args) {
    RomanNumbersEncoder.dict = new HashMap<>();
    // I, II, III, IV, V, VI, VII, VIII, IX, X
    dict.put(1, "I");
    // dict.put(2, "II");
    // dict.put(3, "III");
    // dict.put(4, "IV");
    dict.put(5, "I");
    // dict.put(6, "VI");
    // dict.put(7, "VII");
    // dict.put(8, "VIII");
    // dict.put(9, "IX");
    dict.put(10, "X");
    dict.put(50, "L");
    dict.put(100, "C");
    dict.put(500, "D");
    dict.put(1000, "M");

    RomanNumbersEncoder ins = new RomanNumbersEncoder();
    ins.solution(1666);
  }

  private String solution(int n) {
    if (RomanNumbersEncoder.dict.get(n) != null) {
      return RomanNumbersEncoder.dict.get(n);
    }

    // 1666 → MDCLXVI
    Stack<Integer> stack = new Stack<>();
    int num = n;
    int mul = 1;
    while (num > 0) {
      int mod = num % 10;
      stack.push(mod * mul);
      num /= 10;
      mul *= 10;
    }

    Stack<Integer> reverseStack = new Stack<>();
    while (!stack.isEmpty()) {
      reverseStack.push(stack.pop());
    }

    System.out.println(Arrays.toString(reverseStack.toArray(new Integer[0])));
    return "";
  }

  private int getMul(int n) {
    int num = n;
    int mul = 1;
    while (num > 0) {
      num /= 10;
      mul *= 10;
    }

    return mul;
  }

  private String getRomanNumber(int n) {
    Integer[] keys = RomanNumbersEncoder.dict.keySet().toArray(new Integer[0]);
    for (int i = 0; i < keys.length; i++) {
      if (n <= keys[i]) {
        if (RomanNumbersEncoder.dict.get(n) != null) {
          return RomanNumbersEncoder.dict.get(n);
        }

        int mod = n % getMul(n);
        // 20
        if (mod <= 3) {

        }
      }
    }
  }
}
