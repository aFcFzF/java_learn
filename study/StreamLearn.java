package study;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamLearn {
  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    // String[] result = IntStream.of(nums).mapToObj(item -> new String(0x50 +
    // item)).toArray(String[]::new);
    final byte[] an = { (byte) 0x41 };
    String[] a = IntStream.range(0, 26)
        .mapToObj(idx -> {
          final byte[] bts = { (byte) (idx + 0x41) };
          try {
            return new String(bts, "gbk");
          } catch (UnsupportedEncodingException err) {
            System.err.println("error");
            return "";
          }
        })
        .toArray(String[]::new);
    System.out.println(Arrays.toString(a));
  }
}
