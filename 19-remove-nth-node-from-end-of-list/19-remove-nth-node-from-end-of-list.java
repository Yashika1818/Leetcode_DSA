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
        ListNode slow=dummy; //slow and fast are not new nodes , there are just pointers pointing to dummy node
        ListNode fast=dummy;
        for(int i=0;i<n;i++){
        fast=fast.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
  //      if(slow==dummy)return slow.next.next;  //edge case when head is returned
        slow.next=slow.next.next;
        return dummy.next;  //dummy.next is returned so that edge case is also included
    }
}