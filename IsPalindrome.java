class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int ori = x;
        int result = 0;

        while (x > 0) {
            int mod = x % 10;
            result = result * 10 + mod;
            x /= 10;
        }

        return ori == result;
    }

    public static void main(String[] params) {
        new IsPalindrome().isPalindrome(121);
    }
}