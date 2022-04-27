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
    public ListNode rotateRight(ListNode head, int k) {
        //edge case
        if(head==null || k==0 )return head;
        
       ListNode tmp=head;
        int count=0;
        while(tmp!=null){
            tmp=tmp.next;
            count++;
        }
       // count++;
        if(count==1)return head;
          if(count==k)return head;
        // k=count%k;
         if(k>count){
             k=k%count;
         }
        if(k==0)return head;
        k=count-k;
      
      //  3-4-1=-2
       
        tmp=head;
        while(k!=1){
            k--;
            tmp=tmp.next;
            
        }
        ListNode headnew=tmp.next;
        ListNode dummy=headnew;
        tmp.next=null;
        while(dummy.next!=null){
            dummy=dummy.next;
        }
        dummy.next=head;
        head=headnew;
        
      return head;
    }
}