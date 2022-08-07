public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        helper(0, nums, subset, list);
        return list;
    }
    
    public void helper(int start, int[] nums, List<Integer> subset, List<List<Integer>> list){
        list.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length; i++){
        	
            if(i != start && nums[i] == nums[i - 1]){  
                continue;
            }
            subset.add(nums[i]);
            helper(i + 1, nums, subset, list);
            subset.remove(subset.size() - 1);
        }
    }
}