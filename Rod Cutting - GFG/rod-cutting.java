//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
         int[][] dp=new int[price.length+1][n+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return sol(price,0,n,dp);
    }
    public int sol(int[] val,int idx,int W,int[][] dp){
        if(idx==val.length)return   dp[idx][W]=0;
        if(dp[idx][W]!=-1)return dp[idx][W];
        int take=0;
        if(idx+1<=W)take=val[idx]+sol(val,idx,W-(idx+1),dp);
        int nottake=sol(val,idx+1,W,dp);
        return  dp[idx][W]=Math.max(take,nottake);
    }
}