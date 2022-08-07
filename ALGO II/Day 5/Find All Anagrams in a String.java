class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) return rst;
        
        int n = s.length(), m = p.length();

        int[] hash = new int[256]; // prep p hash, tracks char # 
        for (char c : p.toCharArray()) hash[c]++;
        
        int left = 0, right = 0;
        int count = m; // count of anagram chars. after reducing == 0, found 1 anagram
        
        while (right < n) {
            // move right side of the window, if c exist in window, decrease count
            char c = s.charAt(right++);
            if (hash[c] > 0) count--;
            hash[c]--; // if not exist in anagram, it'll drop to negative
            
            // if anagram char count reduced to 0, an anagram in s is found, mark start pos
            if (count == 0) rst.add(left);
            
            // full range reached, so need to slide the window:
            // 1. get val on left pos
            // 2. add count back (when it is a anagram candidate)
            // 3. + count back to hash 
            if (right - left == m) {
                c = s.charAt(left++); // pick up the left char that will be dropped in next step
                if (hash[c] >= 0) count++; // anagram candidate can be == 0 when evenly used; but can also be  > 0 when there are extra
                hash[c]++;
            }
        }
        return rst;
    }
}