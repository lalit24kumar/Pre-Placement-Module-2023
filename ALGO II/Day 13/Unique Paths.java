class Solution {
    public int uniquePaths(int m, int n) {
		
        // Single dimension array can be used as previous rows data becomes useless except for immediate previous rows
		// whose value is already contained in the dp array
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                // Since robot only moves down or right, it can only arrive from up or left
                // The count of paths till a location is sum of paths till location up and till left
                // The count for above location is already present in dp[j] and count for left is obtained from dp[j-1]
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}