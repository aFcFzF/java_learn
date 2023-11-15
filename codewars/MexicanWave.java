import java.util.Arrays;
import java.util.Objects;
import java.util.LinkedList;

public class MexicanWave {
  public static String[] wave(String str) {
    LinkedList<String> result = new LinkedList<>();

    for (int i = 0; i < str.length(); i++) {
      char mid = Character.toUpperCase(str.charAt(i));
      if (Objects.equals(mid, ' ')) {
        continue;
      }

      String prefix = str.substring(0, i);
      String end = str.substring(i + 1);
      result.add(prefix + mid + end);
    }

    String[] res = Arrays.copyOf(result.toArray(), result.size(), String[].class);
    return res;
  }

  public static void main(String[] args) {
    String[] res = MexicanWave.wave("two words");
    System.out.println(Arrays.toString(res));
  }
}