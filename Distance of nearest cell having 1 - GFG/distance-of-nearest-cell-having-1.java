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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    public class Pair{
        int x;
        int y;
        int d;
        Pair(int x,int y,int d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        Queue<Pair> q=new LinkedList<>();
        int[][] ans=new int[grid.length][grid[0].length];
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                q.add(new Pair(i,j,0));
            }
        }
       
        while(q.size()!=0){
            Pair r=q.remove();
            if(vis[r.x][r.y]==true)continue;
            vis[r.x][r.y]=true;
            ans[r.x][r.y]=r.d;
            addNbr(r.x+1,r.y,r.d+1,q,vis,grid);
             addNbr(r.x,r.y+1,r.d+1,q,vis,grid);
              addNbr(r.x-1,r.y,r.d+1,q,vis,grid);
               addNbr(r.x,r.y-1,r.d+1,q,vis,grid);
        }
        return ans;
        
    }
    public void addNbr(int i,int j,int dist,Queue<Pair> q,boolean[][] vis,int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length|| vis[i][j]==true || grid[i][j]==1)return;
        q.add(new Pair(i,j,dist));
    }
}