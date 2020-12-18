class StringCompare {
    public char findTheDifference(String s, String t) {
        java.util.Map<Character, Integer> map = new java.util.HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            map.put(item, !map.containsKey(item) ? 1 : map.get(item) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char item = t.charAt(i);

            if (!map.containsKey(item)) {
                return t.charAt(i);
            }

            if (map.containsKey(item) && map.get(item) == 0) {
                return t.charAt(i);
            }

            map.put(item, map.get(item) - 1);
        }

        return 'a';
    }

    public static void main(String[] params) {
        new StringCompare().findTheDifference("abc", "abcd");
    }
}
