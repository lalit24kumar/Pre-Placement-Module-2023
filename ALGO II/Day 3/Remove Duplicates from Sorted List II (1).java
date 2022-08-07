class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head.next;
        if(temp.val != head.val){
            head.next = deleteDuplicates(temp);
            return head;
        }else{
            while(temp != null && temp.val == head.val)
                temp = temp.next;
            return deleteDuplicates(temp);
        }
    }
}