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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numSet = new HashSet<>();
        for (int n:nums){
            numSet.add(n);
        }

        while (null!=head && numSet.contains(head.val)){
            head = head.next;
        }

        ListNode temp = head;
        while (null!=temp){
            while (null!=temp.next && numSet.contains(temp.next.val)){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    
        return head;
    }
}