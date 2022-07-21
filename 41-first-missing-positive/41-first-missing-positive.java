class Solution {
    public int firstMissingPositive(int[] nums) {
        int rep=nums.length+1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0)nums[i]=rep;
        }
        
        for(int i=0;i<nums.length;i++){
            if(Math.abs(nums[i])<=nums.length){
                int idx=Math.abs(nums[i])-1;
                if(nums[idx]>0)nums[idx]=-nums[idx];
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)return i+1;
        }
        return rep;
    }
}