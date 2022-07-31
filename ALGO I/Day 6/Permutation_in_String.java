class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s1.length() > s2.length()) {
            return false;
        }
        int m = s1.length(), n = s2.length();
        int[] charCount = new int[26];
        for (int i = 0; i < m; i++) {
            charCount[s1.charAt(i) - 'a']++;
            charCount[s2.charAt(i) - 'a']--;
        }
        
        if (zeroCount(charCount)) return true;
        
        for (int i = m; i < n; i++) {
            charCount[s2.charAt(i) - 'a']--;
            charCount[s2.charAt(i - m) - 'a']++;
            if (zeroCount(charCount)) return true;
        }     
        return false;
    }
    
    private boolean zeroCount(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}