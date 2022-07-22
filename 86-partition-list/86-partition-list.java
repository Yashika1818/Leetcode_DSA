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
    public ListNode partition(ListNode head, int x) {
        if(head==null)return null;
        boolean flag=true;
        ListNode curr=head;
        ListNode start=null;
        ListNode end=null;
        ListNode prev=null;
        ListNode newHd=new ListNode(0);
        ListNode ptr=newHd;
        while(curr!=null){
            if((flag==true && curr.val<x )|| (flag==false && curr.val>=x)){
                prev=curr;
                curr=curr.next;
               
            }else if(curr.val>=x && flag==true){
                flag=false;
                start=prev;
                end=curr;
              }else{
                prev.next=curr.next;
                ptr.next=curr;
                curr.next=null;
                ptr=curr;
                curr=prev.next;
            }
        }
        ptr.next=end;
        if(start!=null)start.next=newHd.next;
        else if(newHd.next!=null)
           return newHd.next;
        
        return head;
    }
}