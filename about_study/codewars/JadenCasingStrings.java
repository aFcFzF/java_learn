/**
 * @file JadenCasingStrings.java
 * @author 9301462@qq.com
 */

public class JadenCasingStrings {
  public static void main(String[] args) {
    JadenCasingStrings ins = new JadenCasingStrings();
    System.out.print(ins.casingStr("a b cd"));
  }

  private String casingStr(String str) {
    boolean nextUpperCase = false;
    char[] result = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      char oriChar = str.charAt(i);
      char upperChar = Character.toUpperCase(str.charAt(i));
      result[i] = nextUpperCase ? upperChar : oriChar;
      nextUpperCase = oriChar == ' ';
    }

    return new String(result);
  }
}
