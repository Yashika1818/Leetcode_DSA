//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Pair{
        int x;
        int y;
        int moves;
        Pair(int x,int y,int moves){
            this.x=x;
            this.y=y;
            this.moves=moves;
        }
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(source[0],source[1],0));
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        while(q.size()>0){
            Pair p=q.remove();
            
            if(visited[p.x][p.y]==true)continue;
            visited[p.x][p.y]=true;
            
            if(p.x==destination[0] && p.y==destination[1]){
                return p.moves;
            }
            
            addN(p.x+1,p.y,q,grid,visited,p.moves+1);
            addN(p.x-1,p.y,q,grid,visited,p.moves+1);
            addN(p.x,p.y+1,q,grid,visited,p.moves+1);
            addN(p.x,p.y-1,q,grid,visited,p.moves+1);
        }
        return -1;
    }
    
    void addN(int i,int j,Queue<Pair> q,int[][] grid,boolean[][] visited,int mov){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j]==true || grid[i][j]==0)return;
        q.add(new Pair(i,j,mov));
    }
}
