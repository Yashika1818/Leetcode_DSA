/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
     
        while(fast!=null && fast.next!=null){ // this condition is when there's no loop
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)return true; // when there's a loop
        }
        
        return false;
    }
}