class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        List<Integer> ans = new ArrayList();
        int anchor = 0, j = 0;
        int n = S.length();
        
        
        for (int i = 0; i < n; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < n; i++) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = j + 1;
            }
        }
        return ans;
    }
}