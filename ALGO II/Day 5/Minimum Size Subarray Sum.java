class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        int low = 0, high = 0;
        int sum = nums[0];
        while(high < len){
            while(sum < s){
                if(++high < len)
                    sum += nums[high];
                else break;
            }
            if(sum >= s){
                while(sum >= s && low <= high){
                    min = Math.min(min, high - low + 1);
                    sum -= nums[low];
                    low++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0: min;
    }
}