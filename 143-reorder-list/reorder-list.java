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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        
        //reach the middle of the list
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow is now at the middle of the list
        //now reverse the second half and break the connection between first and second half
        ListNode second = slow.next;
        ListNode prev = slow.next = null;

        //reverse the list in a way that the last element becomes the head node
        while(second!=null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        //now simply iterate over the first half and keep on adding 
        ListNode first = head;
        second = prev;
        
        while(first!=null && second!=null ){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }

    }

    public String print(ListNode node){
        return node==null?null:""+node.val;
    }
}