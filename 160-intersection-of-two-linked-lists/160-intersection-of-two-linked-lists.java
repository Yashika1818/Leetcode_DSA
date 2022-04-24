/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
    ListNode dummy1=head1;
        ListNode dummy2=head2;
        
        while(dummy1!=dummy2){
            if(dummy1==null){
                dummy1=head2;
            }else
                dummy1=dummy1.next;
            
            if(dummy2==null)dummy2=head1;
            else
                dummy2=dummy2.next;
        }
        return dummy1;
    }
}