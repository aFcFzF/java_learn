/**
 * @file StringAndsWith.java
 * @author markJia(markjia@tencent.com)
 */

public class StringEndsWith {
  public static void main(String[] args) {
    final StringEndsWith ins = new StringEndsWith();
    System.out.printf("%s", ins.solution("abc", "bc"));
  }

  private boolean solution(String str, String ending) {
    final int lEnd = ending.length();

    for (int idx = 0; idx < lEnd; idx++) {
      char lastStrChar = str.charAt(str.length() - 1 - idx);
      char lastEndChar = ending.charAt(lEnd - 1 - idx);

      if (lastStrChar != lastEndChar) {
        return false;
      }
    }

    return true;
  }
}
