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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null)return null;
        if(left==right)return head;
//         1 2 3 4 5 6
//           L     R   
            
        
//          DUMMYLEFT--> L
//             new node()
//          dummyright --> L
//             temp --> new node
//             dummyleft== next
//             dummyleft->next=temp
            
//             5->4>3>2-> null
            
//             newhead=tmp=dummy(0)
//             ptr=dummy()
//             while(ptr!=left){
//                 ptr->ptr.nwxt
//                     if(ptr!=left)
//                 new node(ptr)
//                  tmp.next=  new node
//                    tmp=new node() 
                    
//             }
//            tmp.next=temp
//          tmp= dummyright
//                ptr=right.next
//                while(ptr!=null){
//                    tmp.next=ptr
//                        ptr=ptr.next
//                        tmp=tmp.next
//                }
        
//         1 5 4 3 2 6
            
            
            ListNode p=head;
        ListNode lstart=null;
        ListNode rend=null;
        ListNode l=null;
        ListNode r=null;

        int count=1;
        while(p!=null){
            if(count==left){
                l=p;
            }
            if(count==right){
                r=p;
            }
            if(count==left-1){
                lstart=p;
            }
            if(count==right+1){
                rend=p;
            }
            p=p.next;
            count++;
        }
            
        
      
        ListNode rev=null;
        ListNode t=null;
        ListNode ptr=l;
        while(ptr!=r){
            ListNode n=new ListNode(ptr.val);
            n.next=rev;
            if(rev==null)t=n;
            rev=n;
            ptr=ptr.next;
        }
        
        ListNode n=new ListNode(ptr.val);
        n.next=rev;    
        rev=n;
       
        ListNode newHead=null;
        if(lstart!=null) {
            lstart.next=rev;
            newHead=head;
        }else{
            newHead=rev;
        }
         t.next=rend;
        
        return newHead;
        
    }
}