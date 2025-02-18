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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ListNode sortedHead = new ListNode(0);
        ListNode temp = sortedHead;

        for(ListNode head: lists){
            for(ListNode node = head; node!=null; node=node.next){
                minHeap.add(node.val);
            }
        }

        while(minHeap.peek()!=null){
            temp.next = new ListNode(minHeap.poll());
            temp = temp.next;
        }

        return sortedHead.next;
    }
}