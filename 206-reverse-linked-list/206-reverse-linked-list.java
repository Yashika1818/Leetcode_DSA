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
    public ListNode reverseList(ListNode head) {
        ListNode rev=null;
        ListNode curr=head;
        ListNode tmp=curr;
        while(tmp!=null){
            tmp=tmp.next;
            curr.next=rev;
            rev=curr;
            curr=tmp;
        }
        
        return rev;
    }
}