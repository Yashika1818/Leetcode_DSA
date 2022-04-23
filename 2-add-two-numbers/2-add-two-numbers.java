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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode head=new ListNode();
        ListNode moving=head;
        ListNode curr1=l1;
        ListNode curr2=l2;
        while(curr1!=null && curr2!=null)
        {
            int sum=carry+curr1.val+curr2.val;
            carry=sum/10;
            sum=sum%10;
            
            ListNode tmp=new ListNode(sum);
            moving.next=tmp;
            moving=tmp;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        
        while(curr1!=null){
             int sum=carry+curr1.val;
            carry=sum/10;
            sum=sum%10;
            
            ListNode tmp=new ListNode(sum);
            moving.next=tmp;
            moving=tmp;
            curr1=curr1.next;
            
        }
        while(curr2!=null){
             int sum=carry+curr2.val;
            carry=sum/10;
            sum=sum%10;
            
            ListNode tmp=new ListNode(sum);
            moving.next=tmp;
            moving=tmp;
            curr2=curr2.next;
        }
        if(carry!=0){
               ListNode tmp=new ListNode(carry);
            moving.next=tmp;
            moving=tmp;
        }
        moving.next=null;
        return head.next;
    }
}