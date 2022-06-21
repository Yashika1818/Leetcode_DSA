/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        HashMap<Node,Node> hm=new HashMap<>();
        dfs(node,hm);
        boolean[] visited=new boolean[hm.size()+1];
        adj(node,hm,visited);
        Node n=hm.get(node);
        return n;
        
    }
    public void dfs(Node node, HashMap<Node,Node> hm){
      
        hm.put(node,new Node(node.val));
            
        for(Node nbr:node.neighbors){
              if(!hm.containsKey(nbr)){
                  dfs(nbr,hm);
              }
        }
        return;
    }
    public void adj(Node node,HashMap<Node,Node> hm,boolean[] visited){
        Node n=hm.get(node);
        visited[node.val]=true;
         for(Node nbr:node.neighbors){
            n.neighbors.add(hm.get(nbr));
             if(visited[nbr.val]==false)
            adj(nbr,hm,visited);
        }
    }
}