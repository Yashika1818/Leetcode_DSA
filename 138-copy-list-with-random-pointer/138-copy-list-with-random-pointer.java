/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //STEP 1 : CREATE THE COPY NODES NEXT TO THE ORIGINAL NODES
        Node itr=head;
        Node front=itr;
        while(itr!=null){
             front=itr.next;
             Node copy=new Node(itr.val);
            itr.next=copy;
            copy.next=front;
            itr=front;
        }
        //STEP 2: LINKING THE RANDOM NODES OF COPY LL
        itr=head;
      
        while(itr!=null){
            if(itr.random==null)itr.next.random=null;
            else
            itr.next.random=itr.random.next;
            itr=itr.next.next;
        }
        //STEP 3 : SEPARATING ORIGINAL AND COPY LL
        Node dummy=new Node(0);
        Node temp=dummy;
        itr=head;
        front=head;
        while(itr!=null && itr.next!=null){
          
            front=itr.next.next;
            temp.next=itr.next;
            itr.next=front;
            temp=temp.next;
            itr=front;
        }
        return dummy.next;
    }
}