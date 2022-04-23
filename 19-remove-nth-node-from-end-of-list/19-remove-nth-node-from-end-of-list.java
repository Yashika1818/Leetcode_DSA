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
        ListNode dummy =new ListNode(); //having 0 as default value
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        for(int i=0;i<n;i++){
        fast=fast.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        if(slow==dummy)return slow.next.next;
        slow.next=slow.next.next;
        return head;
    }
}