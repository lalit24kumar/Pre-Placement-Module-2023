

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      Node prev = null;
      for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        if (prev != null) {
          prev.next = node;
        }
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
        prev = node;
      }
      prev.next = null;
    }

    return root;
    }
}