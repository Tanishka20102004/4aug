class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];  // map to store index of each character
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!inCorrectOrder(words[i], words[i + 1], map)) {
                return false;
            }
        }
        return true;
    }

    private boolean inCorrectOrder(String word1, String word2, int[] map) {
        int len = Math.min(word1.length(), word2.length());

        for (int i = 0; i < len; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if (c1 != c2) {
                if (map[c1 - 'a'] > map[c2 - 'a']) {
                    return false;
                } else {
                    return true;
                }
            }
        }

        // If all characters are same in the prefix, then shorter word should come first
        return word1.length() <= word2.length();
    }
}
