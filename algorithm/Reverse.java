/**
 * @file reverse.java
 * @author afcfzf(9301462@qq.com)
 */

class Sol2 {
    public int reverse(int x) {
        int num = 0;
        int max = (int)(Math.pow(2, 31) - 1) / 10;
        int min = (int)Math.pow(-2, 32) / 10;

        while (x / 10 != 0) {
            final int mod = x % 10;
            num = num * 10 + mod;

            if (num > max || num == max && mod > 7) {
                return 0;
            }

            if (num < min || num == min && mod < -8) {
                return 0;
            }

            x /= 10;
        }

        return num;
    }
}
