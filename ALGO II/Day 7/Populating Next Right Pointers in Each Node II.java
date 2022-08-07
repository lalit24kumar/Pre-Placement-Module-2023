class Solution {
    public Node connect(Node root) {
        
        Node dummyHead = new Node(0), curr = dummyHead, ans = root;
        while (root != null) {
           
            if (root.left != null) {
                curr.next = root.left;
                curr = curr.next;
            }
            if (root.right != null) {
                curr.next = root.right;
                curr = curr.next;
            }
            root = root.next;

            
            if (root == null) {
                root = dummyHead.next;
                dummyHead.next = null;
                curr = dummyHead;
            }
        }
        return ans;
    }
}