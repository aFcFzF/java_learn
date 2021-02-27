class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();

        String tmp = "";

        int idx = 0;

        while (idx < s.length()) {
            Character ch = s.charAt(idx);

            if (map.containsKey(ch)) {
                int i = map.get(ch);
                idx = i;

                int len = tmp.length();
                if (len > max) {
                    max = len;
                }

                tmp = "";
                map = new HashMap<>();
            } else {
                tmp += ch;
                map.put(ch, idx);
            }

            idx++;
        }

        int len = tmp.length();

        return max > len ? max : len;
    }
}