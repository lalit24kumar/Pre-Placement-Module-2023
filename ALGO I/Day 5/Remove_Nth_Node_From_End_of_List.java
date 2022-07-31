class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1), pre = new ListNode(0);
        pre.next = head;
        dummy = pre;

        // Establish window
        ListNode end = head; // end node
        while (n--> 0 && end != null) end = end.next;

        // move window
        while (end != null) {
            end = end.next;
            pre = pre.next;
            head = head.next;
        }
        // remove nth node
        pre.next = head.next;
        return dummy.next;
    }
}