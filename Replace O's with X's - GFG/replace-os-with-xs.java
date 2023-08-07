//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static ArrayList<Pair> al;
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean check=false;
                al=new ArrayList<>();
                if(a[i][j]=='O' && vis[i][j]==false)check=dfs(i,j,a,vis);
                // System.out.println(al);
                if(check==true)tofill(al,a);
            }
        }
        return a;
    }
    static boolean dfs(int i,int j,char a[][],boolean[][] vis){
        if(i<0 || j<0 || i>=a.length || j>=a[0].length )return false;
        if(a[i][j]=='X' || vis[i][j]==true)return true;
        
        al.add(new Pair(i,j));
        // System.out.println(al);
        vis[i][j]=true;
        boolean c1=dfs(i+1,j,a,vis);
        boolean c2=dfs(i,j+1,a,vis);
        boolean c3=dfs(i-1,j,a,vis);
        boolean c4=dfs(i,j-1,a,vis);
        
        if(c1 && c2 && c3 && c4)return true;
        return false;
    }
    static void tofill(ArrayList<Pair> al,char a[][]){
        for(Pair p:al){
            a[p.x][p.y]='X';
        }
        return;
    }
}