//{ Driver Code Starts
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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    public int mod=(int)1e9+7;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int[][] dp=new int[n+1][sum+1];
	    
	    dp[arr.length][sum]=1;
	    int tar=sum;
	    for(int i=arr.length-1;i>=0;i--){
	        for(int s=tar;s>=0;s--){
        	    int take=0;
        	    if(arr[i]+s <=tar){
        	        take=dp[i+1][s+arr[i]];
        	    }
        	    int nottake=dp[i+1][s];
        	    dp[i][s]=(take+nottake)%mod;
	        }
	    }
	    // Your code goes here
	    return dp[0][0];
	} 
}