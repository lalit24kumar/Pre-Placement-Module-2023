class Solution {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null;
        ListNode cur = slow.next;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        slow.next = null;
        while(head != null && pre != null){
            dummy.next = head;
            head = head.next;
            dummy = dummy.next;
            dummy.next = pre;
            dummy = dummy.next;
            pre = pre.next;
        }
        if(head != null) dummy.next = head;
    }
}