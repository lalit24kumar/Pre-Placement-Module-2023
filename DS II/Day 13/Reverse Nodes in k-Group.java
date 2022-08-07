public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        
        ListNode p = head;
        int count = 0;
        while(p != null) {
            count ++;
            p = p.next;
        }
        int groups = count / k;
        
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        
        for(int i = 0; i < groups; i ++) {
            int num = 0;
            ListNode cur = pre.next;
            ListNode next = cur.next;

            while(num < k - 1) {
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = cur.next;
                num ++;
            }

            pre = cur;
        }
        
        return dummy.next;
    }
}