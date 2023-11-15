public class SquareDigit {
  public static void main(String[] args) {
    SquareDigit ins = new SquareDigit();
    int res = ins.squareDigits(9119);
    System.out.println(res);
  }

  public int squareDigits(int n) {
    int num = n;
    int result = 0;
    int idx = 0;
    while (num > 0) {
      int bit = num - num / 10 * 10;
      num /= 10;

      int bitResult = bit * bit;
      result = bitResult * (int) Math.pow(10, idx) + result;
      idx += bitResult > 10 ? 2 : 1;
    }

    return result;
  }
}