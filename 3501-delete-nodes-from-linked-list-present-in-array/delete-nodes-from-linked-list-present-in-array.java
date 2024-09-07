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
        Arrays.sort(nums);

        while (null!=head && Arrays.binarySearch(nums,head.val)>=0){
            head = head.next;
        }

        ListNode temp = head;
        while (null!=temp){
            while (null!=temp.next && Arrays.binarySearch(nums,temp.next.val)>=0){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    
        return head;
    }
}