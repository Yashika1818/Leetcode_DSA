class LRUCache {
    class Node{
        int val;
        int key;
        Node prev;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
    int size;
    int cap;
    Node head;
    Node tail;
    HashMap<Integer,Node> hm=new HashMap<>();
    public void addFirst(Node node){
      //  Node node=new Node(value);
       if(head==null){
           head=tail=node;
       }
        else {
            node.next=head;
            head.prev=node;
           // node.prev=null;
            head=node;
        }
        size++;
    }
    public void remove(Node node){
        if(head==null)return;
        if(head==tail){
            head=tail=null;
        }else if(node==head){
            head=head.next;
            head.prev=null;
        }else if(node==tail){
            Node nm1= tail.prev;
            nm1.next=null;
            tail=nm1;
        
            
        }else{
            Node nm1=node.prev;
            Node np1=node.next;
            nm1.next=np1;
            np1.prev=nm1;
        }
        
        size--;
    }
    public LRUCache(int capacity) {  //parameterized constructor of                                              LRUCache
          cap=capacity;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node node=hm.get(key);
            remove(node);
            addFirst(node);
            
            hm.put(key,head);
  
            return node.val;
        }
       
            return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node=hm.get(key);
            remove(node);
            addFirst(node);
            node.val=value;
            hm.put(key,node);
        }else{
            if(size==cap){
                //first we'll remove from hm .
                hm.remove(tail.key);
                remove(tail);
                Node node=new Node(value);
                node.key=key;
                addFirst(node);
                hm.put(key,head);
            }else{
                 Node node=new Node(value);
                node.key=key;
                addFirst(node);
                hm.put(key,head);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */