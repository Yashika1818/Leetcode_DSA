//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int currSum=0;
        int len=0;
        int counter=0;
        hm.put(currSum,-1);
        for(int ar:arr){
            currSum+=ar;
            if(hm.containsKey(currSum)){
                len=Math.max(len,counter-hm.get(currSum));
            }else
                hm.put(currSum,counter);
            
            counter+=1;
        }
        return len;
    }
}