// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    
    //1. dfs nd stack push in postorder
    //2. transpose
    //3.pop nd dfs
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[V];
        for(int v=0;v<V;v++){
            
        if(visited[v]==false){
        dfs(adj,st,visited,v);
        }
        }
       ArrayList<ArrayList<Integer>> adj2=transpose(adj,V);
        
        //  for(int i=0;i<V;i++){
        //     for(int nbr:adj.get(i)){
        //         System.out.print(nbr);
        //     }
        //     System.out.println();
        // }
        
        Arrays.fill(visited,false);
        int cnt=0;
        while(st.size()>0){
            int p=st.pop();
            if(visited[p]==true)continue;
            dfs2(adj2,visited,p);
            cnt++;
        }
      return cnt;  
        
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,boolean[] visited,int src){
        visited[src]=true;
        for(int nbr:adj.get(src)){
            if(visited[nbr]==false){
                dfs(adj,st,visited,nbr);
            }
        }
        st.push(src);
        
    }
    
    public ArrayList<ArrayList<Integer>>  transpose(ArrayList<ArrayList<Integer>> adj,int V){
        ArrayList<ArrayList<Integer>> adj2=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adj2.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            for(int nbr:adj.get(i)){
                adj2.get(nbr).add(i);
            }
        }
          
        
        return adj2;
    }
    public void dfs2(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int src)
    {
        visited[src]=true;
        for(int nbr:adj.get(src)){
            if(visited[nbr]==false){
                dfs2(adj,visited,nbr);
            }
        }
    }
}
