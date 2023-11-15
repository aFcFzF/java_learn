import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Arrays;

public class MorseCodeDecoder {
  static final HashMap<String, String> dict = new HashMap<>();

  static {
    dict.put(".-", "A");
    dict.put("-...", "B");
    dict.put("-.-.", "C");
    dict.put("-..", "D");
    dict.put(".", "E");
    dict.put("..-.", "F");
    dict.put("--.", "G");
    dict.put("....", "H");
    dict.put("..", "I");
    dict.put(".---", "J");
    dict.put("-.-", "K");
    dict.put(".-..", "L");
    dict.put("--", "M");
    dict.put("-.", "N");
    dict.put("---", "O");
    dict.put(".--.", "P");
    dict.put("--.-", "Q");
    dict.put(".-.", "R");
    dict.put("...", "S");
    dict.put("-", "T");
    dict.put("..-", "U");
    dict.put("...-", "V");
    dict.put(".--", "W");
    dict.put("-..-", "X");
    dict.put("-.--", "Y");
    dict.put("--..", "Z");
    dict.put("-----", "0");
    dict.put(".----", "1");
    dict.put("..---", "2");
    dict.put("...--", "3");
    dict.put("....-", "4");
    dict.put(".....", "5");
    dict.put("-....", "6");
    dict.put("--...", "7");
    dict.put("---..", "8");
    dict.put("----.", "9");
  }

  public static String decode(String morseCode) {
    String[] codeWords = morseCode.split(" ");
    StringBuilder result = new StringBuilder();
    boolean skipEmpty = true;

    for (String code : codeWords) {
      if (Objects.equals(code, "")) {
        if (!skipEmpty) {
          skipEmpty = true;
          result.append(" ");
        }

        continue;
      }

      skipEmpty = false;
      String word = MorseCodeDecoder.dict.get(code);
      result.append(word);
    }

    return result.toString();
  }

  public static void main(String[] args) {
    MorseCodeDecoder ins = new MorseCodeDecoder();
    String str = ins.decode("... --- ... ");
    System.out.println(str);
  }
}