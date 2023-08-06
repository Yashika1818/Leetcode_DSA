//{ Driver Code Starts
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
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public class Pair{
        int x;
        int y;
        int t;
        Pair(int x,int y,int t){
            this.x=x;
            this.y=y;
            this.t=t;
        }
    }
    public static int total;
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        // int fresh=0;
        total=0;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }
                if(grid[i][j]==1)total++;
            }
        }
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        int timetaken=0;
        while(q.size()!=0){
            Pair r=q.remove();
            if(vis[r.x][r.y]==true)continue;
            vis[r.x][r.y]=true;
            // System.out.println(fresh+ " "+total+" "+r.t);
            
            // if(fresh==total)return r.t;
            timetaken=Math.max(timetaken,r.t);
            addNbr(r.x+1,r.y,r.t+1,q,vis,grid);
            addNbr(r.x,r.y+1,r.t+1,q,vis,grid);
            addNbr(r.x-1,r.y,r.t+1,q,vis,grid);
            addNbr(r.x,r.y-1,r.t+1,q,vis,grid);
            
            
        }
        //  System.out.println(total);
        if(total==0)return timetaken;
        return -1;
        
    }
    public void addNbr(int i,int j,int ti,Queue<Pair> q,boolean[][] vis,int[][] grid){
        if(i<0 || i>=vis.length || j<0 || j>=vis[0].length ||grid[i][j]==0 || vis[i][j]==true || grid[i][j]==2)return;
        grid[i][j]=2;
        total--;
        q.add(new Pair(i,j,ti));
        
    }
    // 0 2 2
    // 0 2 2
    // 2 2 2
    // 2 1 1
}