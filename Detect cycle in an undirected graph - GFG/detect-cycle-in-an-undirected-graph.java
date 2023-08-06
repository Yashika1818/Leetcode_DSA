//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                boolean check=dfs(adj,vis,i,-1);
                if(check==true)return true;
            }
        }
        return false;
        
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int curr,int src){
        // if(vis[curr]==true)return false;
        vis[curr]=true;
        for(int nbr:adj.get(curr)){
            if(nbr!=src && vis[nbr]==true)return true;
            boolean check=false;
            if(vis[nbr]==false)check=dfs(adj,vis,nbr,curr);
            if(check==true)return true;
        }
        return false;
    }
}