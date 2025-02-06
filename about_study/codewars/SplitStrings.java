import java.util.ArrayList;
import java.util.Arrays;

class SplitStrings {
  public static void main(String[] args) {
    SplitStrings ins = new SplitStrings();
    System.out.println(Arrays.toString(ins.pairs("abc")));
    System.out.println(Arrays.toString(ins.pairs("abcdef")));
  }

  private String[] pairs(String s) {
    ArrayList<String> result = new ArrayList<>();
    String pair = "";
    for (int i = 0; i < s.length(); i++) {
      pair += s.charAt(i);

      if (i == s.length() - 1 && pair.length() == 1) {
        pair += "_";
      }

      if (pair.length() == 2) {
        result.add(pair);
        pair = "";
      }
    }

    return result.toArray(new String[0]);
  }
}