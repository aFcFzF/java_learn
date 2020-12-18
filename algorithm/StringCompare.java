// method1
class StringCompare {
    public char findTheDifference(String s, String t) {
        java.util.Map<Character, Integer> map = new java.util.HashMap<Character, Integer>();

        for (char ch: s.toCharArray()) {
            map.put(ch, !map.containsKey(ch) ? 1 : map.get(ch) + 1);
        }

        for (char ch: t.toCharArray()) {
            if (!map.containsKey(ch)) {
                return ch;
            }

            if (map.containsKey(ch) && map.get(ch) == 0) {
                return ch;
            }

            map.put(ch, map.get(ch) - 1);
        }

        return 'a';
    }

    public static void main(String[] params) {
        Character m1 = new StringCompare().findTheDifference("abc", "abcd");
        Character m2 = new StringCompareM2().diff("abc", "abcd");
        Character m3 = new StringCompareM3().diff("abc", "abcd");
        System.out.println("m1: " + m1);
        System.out.println("m2: " + m2);
        System.out.println("m3: " + m3);
    }
}

class StringCompareM2 {
    public char diff(String s, String t) {
        return (char)(s + t).chars().reduce(0, (a, b) -> a ^ b);
    }
}

class StringCompareM3 {
    public char diff(String s, String t) {
        final int less = s.chars().reduce(0, (a, b) -> a + b);
        final int more = t.chars().reduce(0, (a, b) -> a + b);

        return (char)(more - less);
    }
}
