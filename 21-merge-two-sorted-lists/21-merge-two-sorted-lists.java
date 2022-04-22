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
        ListNode finallist=null;
        ListNode curr1=list1;
        ListNode curr2=list2;
        ListNode head=null;
        while(curr1!=null && curr2!=null){
            
          if(curr1.val<curr2.val){
              if(finallist==null){
                  finallist=curr1;
              }else{
                   finallist.next=curr1;
                   finallist=finallist.next;
                  }
              
              if(head==null)head=curr1;
              curr1=curr1.next;
             // finallist=finallist.next;
              
          } else {
              if(finallist==null){
                  finallist=curr2;
              } else{
                  finallist.next=curr2;
                finallist=finallist.next;
              }
               if(head==null)head=curr2;
              curr2=curr2.next;
            
          } 
        }
        while(curr1!=null){
           if(finallist==null){
                  finallist=curr2;
              } else{
            finallist.next=curr1;
               finallist=finallist.next;
           }
              if(head==null)head=curr1;
            curr1=curr1.next;
          
        }
        while(curr2!=null){
              if(finallist==null){
                  finallist=curr2;
              } else{
            finallist.next=curr2;
                  finallist=finallist.next;}
                if(head==null)head=curr2;
            curr2=curr2.next;
            
            
        }
        return head;
    }
}