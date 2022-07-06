class Solution {
    //as we have to use tickets exactly once, and tickets are edges therefore edges should be used/ traversed once --> euler path
    //qs is related to printing of euler path
    //priority queue is used to get lexical order 
    HashMap<String,PriorityQueue<String>> adj;
    public List<String> findItinerary(List<List<String>> tickets) {
        adj=new HashMap<String,PriorityQueue<String>>();
        //HashSet<String> set=new HashSet<>();
        for(int i=0;i<tickets.size();i++){
            if(adj.containsKey(tickets.get(i).get(0))){
                adj.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
            }else{
                PriorityQueue<String> pq=new PriorityQueue<>();
                pq.add(tickets.get(i).get(1));
                adj.put(tickets.get(i).get(0),pq);
            }
        }
        
        
        LinkedList<String> res=new LinkedList<>();
        dfs("JFK",res);
        
        return res;
    }
    
    public void dfs(String src,LinkedList<String> res){
        if(adj.containsKey(src)==false || adj.get(src).size()==0 ){ //destination case where outdegree/ nbrs are zero 
            res.addFirst(src);
            return;
        }
        
        while(adj.get(src).size()>0){
            String s=adj.get(src).remove();
            //visited scene is not present as vertices can be visited any num of times and edges are being removed
            dfs(s,res);
                  
           
        }
         res.addFirst(src);
  
    }
}