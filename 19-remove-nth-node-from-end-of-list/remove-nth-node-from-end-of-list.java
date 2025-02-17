/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz=0;
        
        for(ListNode temp=head;temp!=null;temp = temp.next, sz++);
        
        int target = sz - n;

        if(target==0) return head.next;

        ListNode temp=head, node=null;

        for(int i=0;i<target-1;i++){
            temp = temp.next;
        }

        node = temp.next;
        temp.next = node.next;
        return head;

    }
}