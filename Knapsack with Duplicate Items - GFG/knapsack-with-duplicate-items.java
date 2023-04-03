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
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] dp=new int[N+1][W+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        // code here
        return sol(val,wt,0,W,dp);
    }
    static int sol(int[] val,int[] wt,int idx,int W,int[][] dp){
        if(idx==wt.length)return   dp[idx][W]=0;
        if(dp[idx][W]!=-1)return dp[idx][W];
        int take=0;
        if(wt[idx]<=W)take=val[idx]+sol(val,wt,idx,W-wt[idx],dp);
        int nottake=sol(val,wt,idx+1,W,dp);
        return  dp[idx][W]=Math.max(take,nottake);
    }
}