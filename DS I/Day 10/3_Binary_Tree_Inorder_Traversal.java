class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (validate(set, node)) {
                stack.pop();
                rst.add(node.val);
                set.add(node);
                continue;
            }
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return rst;
    }
    
    private boolean validate(Set<TreeNode> set, TreeNode node) {
        if(node.left == null && node.right == null) return true;
        boolean left = set.contains(node.left), right = set.contains(node.right);
        if (left && right) return true;
        if ((node.left == null && right) || (node.right == null && left)) return true;
        return false;
    }
}