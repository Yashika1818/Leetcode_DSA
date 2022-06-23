class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        parent=new int[edges.length+1];
        rank=new int[edges.length+1];
        
        for(int v=1;v<=edges.length;v++){
            parent[v]=v;
            rank[v]=0;
        }
        
        for(int[] e:edges){
            int src=e[0];
            int nbr=e[1];
            int srcLead=find(src);
            int nbrLead=find(nbr);
            
            if(srcLead!=nbrLead){
                union(srcLead,nbrLead);
                
            }else{
                return e;
            }
        }
        return null;
    }
    int[] parent;
    int[] rank;
    
    public int find(int s){
        if(parent[s]==s)return s;
        else{
            return parent[s]=find(parent[s]);
        }
    }
    
    public void union(int s,int n){
        if(rank[s]<rank[n]){
            parent[s]=n;
        }else if(rank[n]<rank[s]){
            parent[n]=s;
        }else{
            parent[n]=s;
            rank[s]++;
        }
    }
}