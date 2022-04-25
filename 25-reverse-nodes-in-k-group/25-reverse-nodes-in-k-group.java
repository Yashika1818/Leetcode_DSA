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
    public ListNode reverseKGroup(ListNode head, int k) {
        //edge cases when head==null or k==1 
        if(head==null || k==1)return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy,curr=dummy,nex=dummy;
        int count=0;
        ListNode tmp=head;
        while(tmp!=null){
            tmp=tmp.next;
            count++;
        }
        while(count>=k){
          //  before going to a new subgroup
            curr=prev.next;
            nex=curr.next;
            
            for(int i=0;i<k-1;i++){
                curr.next=nex.next;
                nex.next=prev.next;
                prev.next=nex;
                nex=curr.next;
            }
        // after 
            count-=k;
            prev=curr;
        }
        
        return dummy.next;
    }
}