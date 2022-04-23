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
        ListNode tmp=head;
        int count =0;
        
        while(tmp!=null){
            tmp=tmp.next;
            count++;
        }
        if(count==1 && n==1)return null;
        else if(n==count){
            head=head.next;
            return head;
        }
        int cnt=0;
        tmp=head;
        while(cnt<(count-n)-1){
            tmp=tmp.next;
            cnt++;
        }
      if(tmp!=null && tmp.next!=null)  tmp.next=tmp.next.next;
        return head;
    }
}