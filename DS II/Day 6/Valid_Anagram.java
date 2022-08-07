class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hp = new HashMap<>();
        int lens = s.length(), lent = t.length();

        if (lens != lent) {
            return false;
        }

        for (char chs : s.toCharArray()) {
            hp.put(chs, hp.getOrDefault(chs, 0) + 1);
        }

        for (char cht : t.toCharArray()) {
            if (hp.containsKey(cht)) {
                hp.put(cht, hp.get(cht) - 1);

                if (hp.get(cht) < 0) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
}