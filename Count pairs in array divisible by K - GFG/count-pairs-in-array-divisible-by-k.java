// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long countKdivPairs(int arr[], int n, int k)
    {
        //code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            int rem=arr[i]%k;
            if(hm.containsKey(rem)){
                hm.put(rem,hm.get(rem)+1);
            }else
            hm.put(rem,1);
        }
        int end=k-1;
        long count=0;
        for(int i=1;i<=k/2;i++){
            if(i==end){
                  int num=hm.containsKey(i) ? hm.get(i) : 0;
            count+=num*(num-1)/2;
                break;
            }
            int ith=hm.containsKey(i) ? hm.get(i) : 0;
            int endth=hm.containsKey(end) ? hm.get(end) : 0;
            
                count+=ith*endth;
            
            
            end--;
        }
        
        if(hm.containsKey(0)){
            int num=hm.get(0);
            count+=num*(num-1)/2;
        }
        return count;
    }
    
}