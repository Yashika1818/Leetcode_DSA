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
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int[] ans = obj.articulationPoints(V, adj);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends

//AP is non root , non leaf in which its children are not connected to its above nodes.
class Solution
{
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean[] vis=new boolean[V];
        int[] dis=new int[V]; //discovery
        int[] low=new int[V]; //lower than itself --> its approach till which pt
        HashSet<Integer> aps=new HashSet<>();
        
        for(int v=0;v<V;v++){
            if(vis[v]==false){
                dfs(v,vis,dis,low,aps,adj,-1);
            }
        }
        
            int[] res = new int[aps.size()];
        int idx = 0;
        for(int i: aps){
            res[idx] = i;
            idx++;
        }
        
        if(aps.size() == 0){
            res = new int[] {-1};
        }
        
        Arrays.sort(res);
        
        return res;
    }
    static int time=0;
    public  void dfs(int u,boolean[] vis,int[] dis,int[] low,HashSet<Integer> aps,ArrayList<ArrayList<Integer>> adj,int p){
        vis[u]=true;
        dis[u]=low[u]=++time;
        int cnt=0;
        for(int v:adj.get(u)){
            if(v==p){
                continue;
            }else if(vis[v]==true){
                //already visited ones will only have an impact on low of the parent 
                //iske parent ka low upr wale ke lie kaam ayega, iske parent pr kuch impact nhi pdega
                low[u]=Math.min(dis[v],low[u]);
            }else{
                cnt++;
                //suppose if 1 would have been the parent
                dfs(v,vis,dis,low,aps,adj,u);
                low[u]=Math.min(low[v],low[u]);
                //in post order --> we will check for AP bcz isske parent ke niche ye unvisited wala tha so baad me aya hai , so might be iska parent AP bn skta hai and remove hoskta h
                
                //root node is not included --> bcz root ko remove krne ke baad bhi ek e component bnega which is below it , bcz iske upr toh koi component/node hai e nhi
                if(p!=-1 && dis[u]<=low[v] ){
                    aps.add(u);
                } 
            }
        }
        if(p==-1 && cnt>1){
            aps.add(u);
        }
    }
}