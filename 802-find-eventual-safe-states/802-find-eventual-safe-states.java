// its like topological sort , we are examining the nodes which are safe means which can be calculated easily without such dependence on any one.

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        vis=new int[graph.length];
        
        for(int v=0;v<graph.length;v++){
          
              boolean isSafe=  dfs(v,graph);
              if(isSafe)ans.add(v);
        
        }
        
        return ans;
    }
    
    int[] vis;
     public boolean dfs(int v,int[][] graph){
         if(vis[v]==2)return true;  //already visited and safe
         if(vis[v]==1)return false; //already visited but not safe (may be creating a cycle)
         if(vis[v]==0){
             vis[v]=1;
             
             for(int nbr:graph[v]){
                 boolean isSafe=dfs(nbr,graph);
                 if(isSafe==false)return false;
             }
             
             vis[v]=2;
             return true;
         }
         
         return false;
     }
}