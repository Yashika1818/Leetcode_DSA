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
        HashMap<ListNode,Boolean> hm=new HashMap<>(); //hashmap will contain the reference/address of all the nodes of list bcz of tmp pointer.
        ListNode tmp=head; //here tmp is a pointer of type listnode which points to head . It is not the exact / original node present in the list.
        boolean chck=true;
        while(!hm.containsKey(tmp)){
            if(tmp==null){
                chck=false;
                break;
            }
            hm.put(tmp,true);
            tmp=tmp.next;
        }
        return chck;
    }
}