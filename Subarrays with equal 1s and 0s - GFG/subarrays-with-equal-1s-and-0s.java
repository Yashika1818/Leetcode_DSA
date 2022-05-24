// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<Integer,Integer> hm=new HashMap<> ();
        int psum=0;
        int count=0;
        hm.put(psum,1);
        for(int i=0;i<n;i++){
            if(arr[i]==0){
            psum+=-1;
            }else
            psum+=1;
            if(hm.containsKey(psum)){
                count+=hm.get(psum);
                hm.put(psum,hm.get(psum)+1);
            }else{
                hm.put(psum,1);
            }
        }
        
        return count;
        }
}


