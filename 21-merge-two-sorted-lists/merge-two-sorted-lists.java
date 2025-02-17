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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2, p3=null;
        ListNode newHead = null;

        while(null!=p1 || null!=p2){
            ListNode temp = null;
            // System.out.println(String.format("p1 = %s, p2 = %s, p3 = %s",print(p1), print(p2), print(p3)));
            if(null!=p1 && null!=p2){
                if(p1.val <= p2.val){
                    temp = p1;
                    p1 = p1.next;
                }else{
                    temp = p2;
                    p2 = p2.next;
                }
            }else if(p1==null){
                temp = p2;
                p2 = p2.next;
            }else{
                temp = p1;
                p1 = p1.next;
            }

            // System.out.println("\t temp = "+print(temp));

            if(null==newHead){
                newHead = new ListNode(temp.val);
                p3 = newHead;
            }else{
                p3.next = new ListNode(temp.val);
                p3 = p3.next;
            }
        }

        return newHead;
    }

    public String print(ListNode node){
        return (null==node)?null:""+node.val;
    }
}