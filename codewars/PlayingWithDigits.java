/**
 * @file PlayingWithDigits.java
 * @author afcfzf(9301462@qq.com)
 */

import java.util.Arrays;

public class PlayingWithDigits {
  public static void main(String[] args) {
    PlayingWithDigits ins = new PlayingWithDigits();
    System.out.println(ins.digPow(89, 1));
    System.out.println(ins.digPow(92, 1));
    System.out.println(ins.digPow(46288, 3));
  }

  private long digPow(int n, int p) {
    String[] strList = Integer.toString(n).split("");
    long[] intList = Arrays.asList(strList).stream().mapToLong(Integer::new).toArray();
    long sum = 0;
    for (int i = 0; i < intList.length; i++) {
      long num = intList[i];
      sum += Math.pow(num, i + p);
    }

    return sum % n == 0 ? sum / n : -1;
  }
}
