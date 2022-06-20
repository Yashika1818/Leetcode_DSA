// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find a Mother Vertex in the Graph.
    int cnt=0;
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        //it's tc is V(V+E) bcz we are checking for every Vertex
        //but if we visit thro a vertex 3 nd then move 4 , not all vertices are traversed .
        // it means 3 and 4 vertex can't give results, we can skip dfs for 3 and 4 both once they are visited.
        //but in my code, dfs for 3 and 4 will be separately done.
        for(int i=0;i<V;i++){
            cnt=0;
            boolean[] visited=new boolean[V];
            dfs(adj,i,visited);
            if(cnt==V){
                return i;
            }
        }
        return -1;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>>adj,int src,boolean[] visited){

        cnt++;
        visited[src]=true;
        for(int nbr:adj.get(src)){
            if(visited[nbr]==false){
                dfs(adj,nbr,visited);
            }
        }
      
        return;
    }
}