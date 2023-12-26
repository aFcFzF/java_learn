/**
 * @file SquareEveryDigit.java
 * @author afcfzf(9301462@qq.com)
 */

public class SquareEveryDigit {
  public static void main(String[] args) {
    final int src = 9119;

    int base = 10;

    int result = 0;

    while (src > base) {
      double item = src - (src / base * base);
      result += Math.pow(item, item) * base / 10;
      base *= 10;
    }

    System.out.println(result);
  }
}
