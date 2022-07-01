// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int[][] dp=new int[n][n+1];
	    for(int[] row:dp){
	        Arrays.fill(row,-1);
	    }
	    return helper(arr,dp,0,-1);
	}  
	public int helper(int arr[],int[][] dp,int i,int prev_i){
	    if(i==dp.length)return 0;
	    if(dp[i][prev_i+1]!=-1)return dp[i][prev_i+1];
	    int not_take=helper(arr,dp,i+1,prev_i);
	    int take=0;
	    if(prev_i==-1 || arr[i]>arr[prev_i]){
	        take=arr[i]+helper(arr,dp,i+1,i);
	    }
	    
	    return dp[i][prev_i+1]=Math.max(take,not_take);
	}
}