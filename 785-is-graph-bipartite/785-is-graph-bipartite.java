class Solution {
    public boolean isBipartite(int[][] graph) {
        //there may be more than 1 component of graph --> therefore we need a for loop to traverse thro every vertex (non-visited)
        int[] visited=new int[graph.length];
        Arrays.fill(visited,-1);
        for(int v=0;v<graph.length;v++){
            if(visited[v]==-1){
                boolean isbip=checkcompforbip(graph,visited,v);
                if(isbip==false)return false;
            }
        }
        return true;
    }
    
    
    class Pair{
        int data;
        int level;
        Pair(int data,int level){
            this.data=data;
            this.level=level;
        }
    }
    
    public boolean checkcompforbip(int[][] graph,int[] visited,int src){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,0));
        while(q.size()>0){
            //remove
            Pair rem=q.remove();
            
            //mark*
            if(visited[rem.data]!=-1){  //already visited means cyclic 
                if(visited[rem.data]!=rem.level)return false;
            }
            else{
                visited[rem.data]=rem.level;
            }
            //work
            
            //add*
            for(int nbr: graph[rem.data]){
                if(visited[nbr]==-1)
                    q.add(new Pair(nbr,rem.level+1));
            }
            
            
        }
        return true;
    }
}