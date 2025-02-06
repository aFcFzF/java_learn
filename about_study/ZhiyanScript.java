package study;

import java.util.HashMap;
import java.util.Map;

public class ZhiyanScript {
  public static void main(String[] args) {
    Map<String, Object> dict = new HashMap();
    dict.put("name", "menuClick");

    ZhiyanScript zy = new ZhiyanScript();
    Map<String, Object> result =  zy.transform(dict);
    System.out.println(result);
  }

  public Map<String, Object> transform(Map<String, Object> dict) {
    System.out.println(dict.get("name1") == null ?  "11" : dict.get("name1"));
    if ("menuClick".equals(dict.get("name"))) {
      Map<String, Object> nextDict = new HashMap();
      nextDict.put("1", "2");
      return nextDict;
    }
    return null;
  }
}
