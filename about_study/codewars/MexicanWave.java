import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;
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
    String txt = "two words";
    String[] res = MexicanWave.wave(txt);
    String[] res2 = MexicanWave.waveStream(txt);
    System.out.println("method1: " + Arrays.toString(res));
    System.out.println("method2: " + Arrays.toString(res2));
  }

  public static String[] waveStream(String str) {
    return IntStream.range(0, str.length())
        .mapToObj(idx -> {
          char ch = str.charAt(idx);
          if (ch == ' ') {
            return null;
          }

          return str.substring(0, idx) + Character.toUpperCase(ch) + str.substring(idx + 1);
        })
        .filter(Objects::nonNull)
        .toArray(String[]::new);
  }
}