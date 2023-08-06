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
    public class Pair{
        int u;
        int u_sr;
        Pair(int u,int u_sr){
            this.u=u;
            this.u_sr=u_sr;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                boolean check=cycle(i,adj,vis);
                if(check==true)return true;
            }
        }
        return false;
        
    }
    public boolean cycle(int src,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,-1));
        while(q.size()!=0){
            Pair r=q.remove();
            if(vis[r.u]==true)continue;
            vis[r.u]=true;
            
            for(int nbr:adj.get(r.u)){
                if(nbr!=r.u_sr && vis[nbr]==true)return true;
                q.add(new Pair(nbr,r.u));
            }
            
            
        }
        return false;
    }
}