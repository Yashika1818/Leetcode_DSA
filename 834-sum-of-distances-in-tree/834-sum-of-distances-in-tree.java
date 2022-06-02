class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // this ques is of the graph form.
        // create a node array --> it cotains the nodes below it and including it.
        //also a resultant edge array --> it contains the total edge distance from that node to all the other nodes below it
        //we need a arraylist in front of every node to store its children
        
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(edges[i][1]);
           graph[edges[i][1]].add(edges[i][0]);
        }
        int nodes[]=new int[n];
        int res[]=new int[n];
        //now taking source as 0 and its parent as -1, let's call the helper fn which will give us the correct sum of distances bet 0 and all other stored in resultant edge array.
        //we need to pass parent to prevent overflow
        helper(graph,nodes,res,0,-1);
        //but for all other nodes , its not the correct ans as stored in resultant array , for that we need to call another helper fn too
        helper2(graph,nodes,res,0,-1);
        return res;
    }
    
    public void helper(ArrayList<Integer>[] graph,int[] nodes,int[] res, int src, int prnt){
        
        for(int nbr:graph[src]){
            if(nbr!=prnt){
            helper(graph,nodes,res,nbr,src);
            nodes[src]+=nodes[nbr];
            res[src]+=nodes[nbr]+res[nbr];
            }
        }
        
        nodes[src]++;
    }
    public void helper2(ArrayList<Integer>[] graph,int[] nodes,int[] res, int src, int prnt){
        
        for(int nbr:graph[src]){
            if(nbr!=prnt){
            //pre-order will work to fill the array of parent first
            res[nbr]=res[src]-nodes[nbr]+(nodes.length-nodes[nbr]);
               
            helper2(graph,nodes,res,nbr,src);
           
            }
        }
        
    }
}