class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0)nums[i]=nums.length+1;
        }
        for(int i=1;i<=nums.length;i++){
            int j=nums[i-1];
            if(j<0)j=-j;
            if(j!=0 && j-1<nums.length && nums[j-1]>0)nums[j-1]=-nums[j-1];
        }
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]>0)return i;
        }
        return nums.length+1;
    }
}