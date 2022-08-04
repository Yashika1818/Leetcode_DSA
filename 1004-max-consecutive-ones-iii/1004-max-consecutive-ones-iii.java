class Solution {
    public int longestOnes(int[] nums, int k) {
        int cnt0=0;
        int i=0,j=0;
        int maxi=0;
        while(i<=j && j<nums.length){
            if(nums[j]==0)cnt0++;
          
            if(cnt0>k){
            while(i<nums.length && nums[i]!=0){
                i++;
            }
                i++;
                cnt0--;
                
                }
             
                maxi=Math.max(maxi,j-i+1);
                j++;
            
        }
        
        return maxi;
    }
}