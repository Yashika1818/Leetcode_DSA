// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
        Arrays.sort(nums);
        boolean[] vis=new boolean[nums.length];
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(vis[i]==true || hm.get(nums[i])==i)continue;
            int cnt=0;
            int j=i;
            do{
                vis[j]=true;
                j=hm.get(nums[j]);
                cnt++;
            }while(j!=i);
            ans+=(cnt-1);
        }
        return ans;
    }
}