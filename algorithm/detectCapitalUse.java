class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null) {
            return false;
        }

        String up = word.toUpperCase();
        String lower = word.toLowerCase();

        if (up.equals(word)) {
            return true;
        }

        if (lower.equals(word)) {
            return true;
        }

        if (word.substring(0, 1).equals(up.substring(0, 1)) && word.substring(1).equals(lower.substring(1))) {
            return true;
        }

        return false;
    }
}
