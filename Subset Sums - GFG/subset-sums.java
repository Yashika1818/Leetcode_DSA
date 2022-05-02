// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        if(N==0){
            ArrayList<Integer> al=new ArrayList<>();
            al.add(0);
            return al;
        }
        ArrayList<Integer> prev=subsetSums(arr,N-1);
        int n=prev.size();//it needs to be store at start, bcz its size is changing during the loop
        for(int i=0;i<n;i++){
            prev.add(prev.get(i)+arr.get(N-1));
        }
       
        return prev;
    }
}