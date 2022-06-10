// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    // if cut1=k/2 > n
    // then cut1=n
    public long kthElement( int nums1[], int nums2[], int n, int m, int k) {
         if(nums2.length<nums1.length) return kthElement(nums2,nums1,m,n,k);
        int n1=nums1.length;
        int n2=nums2.length;
        // min partition from array1 is suppose worst case n1==n2 and k>n1 , then atleast we have to take k-n1 elements from array1 and max partition from array1 is min(k,n1) i.e if we have to only 
          // want kth element and n> k then maximum we can take only k elements.
        int lo=Math.max(0,k-n2),hi=Math.min(k,n1); 
        while(lo<=hi){
            int cut1=(lo+hi)/2;
            int cut2=k - cut1;
            int l1=(cut1==0 ? Integer.MIN_VALUE : nums1[cut1-1]);
            int l2= (cut2==0 ? Integer.MIN_VALUE : nums2[cut2-1]);
            int r1=(cut1==n1 ? Integer.MAX_VALUE : nums1[cut1]);
            int r2=(cut2==n2 ? Integer.MAX_VALUE : nums2[cut2]);
            if(l1<=r2 && l2<=r1){
                    return (long)(Math.max(l1,l2));
            }else if(l1 > r2){
                hi= cut1-1;
                
            }else{
                lo=cut1+1;
            }
        }
        return -1;
    
        
    }
}