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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

    public int minDiff;
	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	   
	    int total=0;
	    for(int a:arr){
	        total+=a;
	    }
	     minDiff=total;
	    int tar=(total)/2;
	    Boolean[][] dp=new Boolean[n+1][tar+1];
	    boolean exist=recursion(arr,0,0,tar,total,dp);
	    return minDiff;
	} 
	public boolean recursion(int[] arr,int i,int sum,int tar,int total,Boolean[][] dp){
	    if(i==arr.length && sum==tar)return dp[i][sum]=true;
	    else if(i==arr.length)return dp[i][sum]=false;
	    if(dp[i][sum]!=null)return dp[i][sum];
	    boolean take=false;
	    if(sum+arr[i] <= tar){
	        if(Math.abs(sum+arr[i]-Math.abs(total-(sum+arr[i])))<minDiff)
	        minDiff =Math.abs(sum+arr[i]-Math.abs(total-(sum+arr[i])));
	       take= recursion(arr,i+1,sum+arr[i],tar,total,dp);
	    }
	    boolean nottake=recursion(arr,i+1,sum,tar,total,dp);
	    
	    return dp[i][sum]=(take||nottake);
	}
}
