class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return ans;
        }
        
        Arrays.sort(nums);
        
        int len = nums.length;
        
        for (int i = 0; i < len - 2; i++) {
            int cur = nums[i];
            
            if (i > 0 && cur == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = len - 1;
            
            while (left < right) {
                int tempSum = nums[i] + nums[left] + nums[right];
                
                if (tempSum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    } 
                }
                else if (tempSum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        
        return ans;
    }
}