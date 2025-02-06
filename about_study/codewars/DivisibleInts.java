/**
 * @file DivisibleInts.java
 * @author afcfzf(9301462@qq.com)
 */

class DivisibleInts {
  public static void main(String[] args) {
    DivisibleInts ins = new DivisibleInts();
    System.out.println("结果：" + ins.getCount(1111111111));
  }

  private int getCount(int n) {
    String intStr = Integer.toString(n);
    int count = 0;
    for (int i = 0; i < intStr.length(); i++) {
      for (int j = i; j < intStr.length(); j++) {
        String subStr = intStr.substring(i, j + 1);

        int num = Integer.parseInt(String.join("", subStr));

        if (n != num && num != 0 && n % num == 0) {
          count += 1;
        }
      }
    }
    return count;
  }
}


