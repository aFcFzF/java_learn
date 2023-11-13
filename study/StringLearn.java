package study;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringLearn {
  /**
   * 字符串
   * 1. 拼接
   * 2. 分割
   * 3. 读字符
   * 4. 遍历有几种方法?
   * 5. 判断为空
   * 6. 大小写
   * 7. 模板字符
   * 8. String对象
   */
  public static void main(String[] args) {
    // 拼接
    String a = "A";
    String b = "B";
    String aAndB = a + b;
    System.out.println(aAndB);

    // 分割
    System.out.println(aAndB.split("")[0]);

    // 读字符
    System.out.println(aAndB.charAt(1));

    // 遍历1
    for (int i = 0; i < aAndB.length(); i++) {
      System.out.println("遍历" + aAndB.charAt(i));
    }

    // 遍历2
    for (String ch : aAndB.split("")) {
      System.out.println("遍历: " + ch);
    }

    // 遍历3
    Arrays.asList(aAndB.split("")).stream().forEach(ch -> System.out.println("stream 遍历: " + ch));

    // 遍历4
    Stream.of(aAndB.split("")).forEach(System.out::println);

    // 判断为空
    System.out.println("".isEmpty());
    System.out.println("" == "");
    System.out.println("".equals(""));

    // 大小写
    System.out.println("大写: " + "a".toUpperCase());
    System.out.println("小写: " + "A".toLowerCase());
  }
}
