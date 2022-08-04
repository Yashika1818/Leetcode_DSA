class Solution {
    public int findMin(int[] nums) {
        int z=0;
        int lo=0;
        int hi=nums.length-1;
        while(lo<hi){
            int mid=(lo+hi)/2;
            //as nums[mid]<nums[hi] therefore we cant ignore mid , mid can also be the ans
            if(nums[mid]<nums[hi] )hi=mid;
            
            else
            lo=mid+1;
        }
        return nums[lo];
    }
}