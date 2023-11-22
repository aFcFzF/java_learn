import java.util.HashMap;

class Info {
  public final String ch;
  public int count = 0;

  public Info(String ch) {
    this.ch = ch;
  }
}

public class ValidBraces {
  public static void main(String[] args) {
    ValidBraces ins = new ValidBraces();
    System.out.println(ins.checkValidBrace("({})"));
  }

  private boolean checkValidBrace(String str) {
    HashMap<String, String> dict = new HashMap<>();
    dict.put("(", ")");
    dict.put("[", "]");
    dict.put("{", "}");

    HashMap<String, Info> map = new HashMap<>();
    map.put("}", new Info("{"));
    map.put("]", new Info("["));
    map.put(")", new Info("("));


    String[] arr = str.split("");

    for (String key : arr) {
      // 如果是左括号，加1
      if (!map.containsKey(key)) {
        Info info = map.get(dict.get(key));
        info.count += 1;
        continue;
      }

      Info info = map.get(key);
      if (info.count <= 0) {
        return false;
      }

      info.count--;
    }

    return map.values().stream()
      .mapToInt(item -> item.count)
      .sum() == 0;
  }
}
