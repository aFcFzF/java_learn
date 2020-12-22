
public class ReverseNum {
    public int reverseNum(int num) {
        int result = 0;

        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }

        return result;
    }

    public static void main(String[] params) {
        int result = new ReverseNum().reverseNum(1999) + new ReverseNum().reverseNum(9);
        System.out.println(result);
    }
}