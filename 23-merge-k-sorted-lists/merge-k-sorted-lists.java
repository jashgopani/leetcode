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
        if(lists.length==0) return null;

        int k = lists.length;
        ListNode sortedList = lists[0];
        for(int i=1; i < lists.length;i++){
            sortedList = mergeLists(sortedList, lists[i]);
        }
        return sortedList;
    }

    public ListNode mergeLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if(l1!=null){
            tail.next = l1;
        }else{
            tail.next = l2;
        }

        return dummy.next;
    }
}