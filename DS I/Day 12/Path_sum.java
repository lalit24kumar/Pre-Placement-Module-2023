public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return false; 
        int expect=sum-root.val; 
        if(expect==0 && root.left==null && root.right==null) return true; 
        boolean left=hasPathSum(root.left, expect);
        boolean right=hasPathSum(root.right, expect);
        return left || right; 
    }
}